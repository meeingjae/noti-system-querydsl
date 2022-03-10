package com.toy.notification.domain.user.entity;

import org.springframework.data.rest.core.config.Projection;

public interface UserProjection {

    @Projection(name = "getUserId", types = User.class)
    interface getUserId {

        Long getUserId();
    }

}
