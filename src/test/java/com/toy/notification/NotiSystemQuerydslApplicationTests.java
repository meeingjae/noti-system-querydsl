package com.toy.notification;

import com.toy.notification.domain.company.Company;
import com.toy.notification.domain.company.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NotiSystemQuerydslApplicationTests {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    void contextLoads() {

    }

    @Test
    public void companySaveTest() {

        companyRepository.save(Company.builder()
                .companyId(1L)
                .name("test").build());

        List<Company> company = companyRepository.findAllCompany();

        System.out.println(company);
        assert company.size() == 1;
    }

}
