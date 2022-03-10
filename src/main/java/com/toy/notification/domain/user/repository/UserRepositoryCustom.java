package com.toy.notification.domain.user.repository;

import java.util.List;

public interface UserRepositoryCustom {

    boolean existByUserId(long id);

    List<Long> findIdsByUserName(long companyId, List<String> userName);
}