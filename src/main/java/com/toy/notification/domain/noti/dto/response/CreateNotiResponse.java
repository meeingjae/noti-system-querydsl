package com.toy.notification.domain.noti.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@RequiredArgsConstructor
public class CreateNotiResponse {


    private final long createCount;
    private final status status;


    @RequiredArgsConstructor
    @Getter
    public enum status {
        OK(HttpStatus.OK, "create success"),
        NOT_FOUND_USER(HttpStatus.NOT_FOUND, "request user not found");

        private final HttpStatus httpStatus;
        private final String     createResultMessage;
    }
}
