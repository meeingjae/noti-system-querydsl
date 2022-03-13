package com.toy.notification.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class ResponseStatus {

    private final HttpStatus httpStatus;
    private final String     responseMessage;
}
