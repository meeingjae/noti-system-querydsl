package com.toy.notification;

import com.toy.notification.domain.company.Company;
import com.toy.notification.domain.company.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class NotiSystemQuerydslApplicationTests {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void companySaveTest() {

        Company company = companyRepository.save(Company.builder()
                .name("test").build());

        List<Company> companyList = companyRepository.findAllCompany();

        System.out.println(company);
        assert company.getName().equals("test");
        assert companyList.size() == 1;
    }

}
