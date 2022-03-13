package com.toy.notification.domain.noti.service;

import com.toy.notification.domain.noti.dto.request.CreateNoti;
import com.toy.notification.domain.noti.dto.response.CreateNotiResponse;
import com.toy.notification.domain.noti.entity.Noti;
import com.toy.notification.domain.noti.entity.NotiReceive;
import com.toy.notification.domain.noti.repository.NotiReceiveRepository;
import com.toy.notification.domain.noti.repository.NotiRepository;
import com.toy.notification.domain.user.repository.UserRepository;
import com.toy.notification.util.ResponseStatus;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

/**
 * Notification Service
 */
@RequiredArgsConstructor //fianl , NonNull인 녀석들에 대한 생성자 생성
public class NotiServiceImpl implements NotiService {

    private final NotiRepository        notiRepository;
    private final NotiReceiveRepository notiReceiveRepository;
    private final UserRepository        userRepository;

    @Override
    public CreateNotiResponse create(long companyId, long userId, CreateNoti request) {

        // 전송 가능한 User들의 Id 목록 조회
        List<Long> userIds = userRepository.findSendAvailableUserIds(companyId, request.getReceiveUserList());

        // 전송 가능한 User가 없을 경우 응답 - 실패
        if (userIds.isEmpty()) {
            return CreateNotiResponse.builder()
                    .createCount(0)
                    .status(new ResponseStatus(NOT_FOUND,"request user not found"))
                    .build();
        }

        // Notification 전송
        Noti noti = notiRepository.save(Noti.builder()
                .message(request.getMessage())
                .userId(userId)
                .notiReceiveList(userIds.stream()
                        .map(targetUserId -> NotiReceive.builder().notiReceiveId(targetUserId).build())
                        .collect(Collectors.toList()))
                .build());

        // 응답 - 성공
        return CreateNotiResponse.builder()
                .createCount(noti.getNotiReceiveList().size())
                .status(new ResponseStatus(OK, "create success"))
                .build();
    }

}
