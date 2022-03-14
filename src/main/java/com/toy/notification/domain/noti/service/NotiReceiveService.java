package com.toy.notification.domain.noti.service;

import com.toy.notification.domain.noti.dto.request.UpdateNoti;
import com.toy.notification.domain.noti.dto.response.DeleteNotiResponse;
import com.toy.notification.domain.noti.dto.response.ListNotiResponse;
import org.springframework.stereotype.Service;

@Service
public interface NotiReceiveService {

    ListNotiResponse list(long userId);

    DeleteNotiResponse delete(UpdateNoti request);
}
