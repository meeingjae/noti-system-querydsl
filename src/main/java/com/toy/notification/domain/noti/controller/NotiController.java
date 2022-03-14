package com.toy.notification.domain.noti.controller;

import com.toy.notification.domain.noti.dto.request.CreateNoti;
import com.toy.notification.domain.noti.dto.response.NotiResponse;
import com.toy.notification.domain.noti.service.NotiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * notification controller
 */
@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotiController {

    private final NotiService notiService;

    /**
     * Notification을 생성한다
     *
     * @param companyId 회사 id 값
     * @param userId    유저 id 값
     * @param request   Noti 생성 요청 데이터
     * @return Noti 생성 결과
     */
    @PostMapping
    public ResponseEntity<NotiResponse> create(
            @RequestHeader(value = "companyId", required = true, defaultValue = "1") long companyId,
            @RequestHeader(value = "userId", required = true) long userId,
            @RequestBody @Validated CreateNoti request) {

        NotiResponse response = notiService.create(companyId, userId, request);

        return new ResponseEntity<NotiResponse>(
                response,
                Arrays.stream(HttpStatus.values())
                        .filter(httpStatus -> httpStatus.equals(response.getStatus().getHttpStatus()))
                        .findAny().get());
    }
}
