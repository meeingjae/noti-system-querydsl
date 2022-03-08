package com.toy.notification.domain.company;

import com.querydsl.jpa.impl.JPAQueryFactory;
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
