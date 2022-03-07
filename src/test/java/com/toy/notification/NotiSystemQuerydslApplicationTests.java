package com.toy.notification;

import com.toy.notification.domain.company.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
class NotiSystemQuerydslApplicationTests {

    @Autowired
    private CompanyRepository companyRepository;

    @Transactional
    @Test
    public void companySaveTest() {
        //TODO : Test 문제 해결 후 gradle build -x test 옵션 해제할 것

        Long createCount = companyRepository.createCompany(1L, "mingCompany");

        assert (createCount.equals(1L));
    }

}
