package com.toy.notification.domain.user.repository;

import com.toy.notification.domain.user.entity.User;

import java.util.List;

public interface UserRepositoryCustom {

    boolean existByUserId(long id);

    List<Long> findSendAvailableUserIds(long companyId, List<String> userName);

    User findByCompanyAndUserId(long companyId, long userId);
}