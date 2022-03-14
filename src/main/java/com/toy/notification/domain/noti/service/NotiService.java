package com.toy.notification.domain.noti.service;

import com.toy.notification.domain.noti.dto.request.CreateNoti;
import com.toy.notification.domain.noti.dto.response.NotiResponse;
import org.springframework.stereotype.Service;

@Service
public interface NotiService {

    NotiResponse create(long companyId, long userId, CreateNoti request);
}
