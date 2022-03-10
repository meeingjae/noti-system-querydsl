package com.toy.notification.domain.company.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toy.notification.domain.company.entity.Company;
import com.toy.notification.domain.company.entity.QCompany;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CompanyRepositoryCustomImpl implements CompanyRepositoryCustom {

    private final JPAQueryFactory factory;

    @Override
    public List<Company> findAllCompany() {

        return factory
                .selectFrom(QCompany.company)
                .fetch();
    }
}
