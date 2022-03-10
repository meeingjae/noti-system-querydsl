package com.toy.notification.domain.company.repository;

import com.toy.notification.domain.company.entity.Company;

import java.util.List;

public interface CompanyRepositoryCustom {

    List<Company> findAllCompany();
}