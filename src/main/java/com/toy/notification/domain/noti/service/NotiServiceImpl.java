package com.toy.notification.domain.noti.service;

import com.toy.notification.domain.noti.dto.request.CreateNoti;
import com.toy.notification.domain.noti.dto.response.CreateNotiResponse;
import com.toy.notification.domain.noti.repository.NotiReceiveRepository;
import com.toy.notification.domain.noti.repository.NotiRepository;
import com.toy.notification.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

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



        return null;
    }

}
