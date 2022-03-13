package com.toy.notification.domain.noti.dto.request;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ListNoti {

    private final String message;

    private final boolean readFlag;
}
