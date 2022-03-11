package com.toy.notification.domain.noti.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class CreateNoti {

    @NotNull
    private final String message;

    @NotEmpty
    private final List<String> receiveUserList;
}
