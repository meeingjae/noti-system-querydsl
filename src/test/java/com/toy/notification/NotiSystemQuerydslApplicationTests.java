package com.toy.notification;

import com.toy.notification.domain.company.entity.Company;
import com.toy.notification.domain.company.repository.CompanyRepository;
import com.toy.notification.domain.noti.controller.NotiController;
import com.toy.notification.domain.noti.dto.response.ListNotiResponse;
import com.toy.notification.domain.noti.entity.Noti;
import com.toy.notification.domain.noti.entity.NotiReceive;
import com.toy.notification.domain.noti.repository.NotiReceiveRepository;
import com.toy.notification.domain.noti.repository.NotiRepository;
import com.toy.notification.domain.noti.service.NotiService;
import com.toy.notification.domain.user.entity.User;
import com.toy.notification.domain.user.repository.UserRepository;
import org.hibernate.PropertyValueException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

    //TODO : Application Context 로딩 못하는 문제
    // MockBean으로 Controller, Service 명시. --> 명시하지 않고 해결하는 방법 검토 필요
    @MockBean
    private NotiController notiController;

    @MockBean
    private NotiService notiService;

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

        noti.getNotiReceiveList()
                .forEach(chield ->
                        System.out.println(""
                                + "chield Id : " + chield.getUserId() +
                                " parentId : " + chield.getNoti().getNotiId()));
    }

    @Test
    public void projectionTest() {

        List<Long> result = userRepository.findSendAvailableUserIds(1L, List.of("notExistUser"));

        assert result.isEmpty();
    }

    @Test
    public void nullValidTest() throws PropertyValueException {

        try {
            userRepository.save(User.builder()
                    .companyId(null)
                    .userName("ming")
                    .build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void notiListTest() {

        Noti firstNoti = notiRepository.save(Noti.builder()
                .userId(1L)
                .message("first message")
                .build());

        Noti secondNoti = notiRepository.save(Noti.builder()
                .userId(1L)
                .message("second message")
                .build());

        notiReceiveRepository.saveAll(List.of(
                NotiReceive.builder()
                        .noti(firstNoti)
                        .userId(2L)
                        .readFlag(true)
                        .build(),
                NotiReceive.builder()
                        .noti(firstNoti)
                        .userId(3L)
                        .readFlag(true)
                        .build(),
                NotiReceive.builder()
                        .noti(firstNoti)
                        .userId(4L)
                        .readFlag(true)
                        .build(),
                NotiReceive.builder()
                        .noti(secondNoti)
                        .userId(2L)
                        .readFlag(true)
                        .build()));
        List<ListNotiResponse.NotiResponseObject> object = notiReceiveRepository.list(2L);

        System.out.println("size : " + object.size());
        object.forEach(System.out::println);

        assert object.size() == 2;
    }
}
