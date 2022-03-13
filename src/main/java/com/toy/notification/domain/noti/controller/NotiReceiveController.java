package com.toy.notification.domain.noti.controller;

import com.toy.notification.domain.noti.dto.response.ListNotiResponse;
import com.toy.notification.domain.noti.service.NotiReceiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RequiredArgsConstructor
@RestController
@RequestMapping("/notification/receive")
public class NotiReceiveController {

    private final NotiReceiveService service;

    @GetMapping
    public ResponseEntity<ListNotiResponse> list(@RequestHeader(value = "userId", required = true) long userId) {

        ListNotiResponse result = service.list(userId);
        return new ResponseEntity<ListNotiResponse>(result,
                Arrays.stream(HttpStatus.values())
                        .filter(httpStatus -> httpStatus.equals(result.getStatus().getHttpStatus()))
                        .findFirst().get());
    }
}
