package com.toy.notification.domain.company;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>, CompanyRepositoryCustom {

    private final JPAQueryFactory factory;

    QCompany company = QCompany.company;

    public long createCompany(long id, String name) {

        return factory.insert(company)
                .columns(company.companyId, company.name)
                .values(id, name)
                .execute();
    }
}
