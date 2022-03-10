package com.toy.notification.domain.noti.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class CreateNotiResponse {

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
