package com.toy.notification.domain.company;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CompanyRepository {

    private final JPAQueryFactory factory;

    QCompany company = QCompany.company;

    public long createCompany(long id, String name) {

        return factory.insert(company)
                .columns(company.companyId, company.name)
                .values(id, name)
                .execute();
    }
}
