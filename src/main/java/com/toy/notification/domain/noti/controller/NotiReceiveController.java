package com.toy.notification.domain.noti.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification/receive")
public class NotiReceiveController {

    @GetMapping
    public ResponseEntity list(
            @RequestHeader(value = "companyId", required = true, defaultValue = "1") long companyId,
            @RequestHeader(value = "userId", required = true) long userId) {

        return null;
    }
}
