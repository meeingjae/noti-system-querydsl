package com.toy.notification.domain.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserDeleteRequest {

    private final long userId;
}
