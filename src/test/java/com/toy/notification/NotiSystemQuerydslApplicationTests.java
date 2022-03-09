package com.toy.notification;

import com.toy.notification.domain.company.Company;
import com.toy.notification.domain.company.CompanyRepository;
import com.toy.notification.domain.noti.Noti;
import com.toy.notification.domain.noti.NotiReceive;
import com.toy.notification.domain.noti.NotiReceiveRepository;
import com.toy.notification.domain.noti.NotiRepository;
import com.toy.notification.domain.user.User;
import com.toy.notification.domain.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUtil;
import javax.persistence.metamodel.Metamodel;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class NotiSystemQuerydslApplicationTests {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotiRepository notiRepository;

    @Autowired
    private NotiReceiveRepository notiReceiveRepository;

    @Autowired
    private EntityManagerFactory factory;

    @Test
    public void companySaveTest() {

        Company company = companyRepository.save(Company.builder()
                .name("test").build());

        List<Company> companyList = companyRepository.findAllCompany();

        System.out.println(company);
        assert company.getName().equals("test");
        assert companyList.size() == 1;
    }

    @Test
    public void userExistQueryTest() {

        userRepository.save(User.builder()
                .companyId(1L)
                .userName("ming")
                .build());

        System.out.println("Jpa Method Query");
        boolean first = userRepository.existsById(1L);
        System.out.println("querydsl limit query");
        boolean second = userRepository.existByUserId(1L);

        assert first;
        assert second;
    }

    @Test
    public void persisteneceContextTest() {

        System.out.println("First save");
        User user = userRepository.save(User.builder()
                .companyId(1L)
                .userName("ming")
                .build());

        user.setUserName("changedming");

        System.out.println("Second save");
        userRepository.save(user);
    }

    @Test
    public void oneToManyTest() {

        // Entity Load 정보 조회
        PersistenceUtil persistenceUtil = factory.getPersistenceUnitUtil();

        //모든 Entity 조회
        Metamodel metamodel = factory.getMetamodel();

        System.out.println(metamodel.getEntities());

        Noti noti = notiRepository.save(
                Noti.builder()
                        .message("test Mesage")
                        .userId(99L)
                        .build());

        List<NotiReceive> notiReceiveList = notiReceiveRepository.saveAllAndFlush(
                List.of(
                        NotiReceive.builder()
                                .userId(100L)
                                .noti(noti)
                                .build(),
                        NotiReceive.builder()
                                .userId(101L)
                                .noti(noti)
                                .build())
        );

        noti.setNotiReceiveList(notiReceiveList);

        noti = notiRepository.save(noti);

        System.out.println("noti initialize ? ");
        System.out.println(persistenceUtil.isLoaded(noti));

        System.out.println("noti receive initialize ? ");
        System.out.println(persistenceUtil.isLoaded(noti, "notiReceiveList"));

//        noti.getNotiReceiveList()
//                .forEach(chield ->
//                        System.out.println(""
//                                + "chield Id : " + chield.getUserId() +
//                                " parentId : " + chield.getNoti().getNotiId()));
    }
}
