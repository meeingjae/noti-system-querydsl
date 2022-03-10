package com.toy.notification.domain.noti.dto.request;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CreateNoti {

    private final String message;

    private final List<Long> receiveUserList;

    private final Boolean sendAllFlag;
}
