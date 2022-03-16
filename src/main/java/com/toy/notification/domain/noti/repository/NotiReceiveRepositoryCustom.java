package com.toy.notification.domain.noti.repository;

import com.toy.notification.domain.noti.entity.NotiReceive;

import java.util.List;

import static com.toy.notification.domain.noti.dto.response.ListNotiResponse.NotiResponseObject;

public interface NotiReceiveRepositoryCustom {

    List<NotiReceive> findAllByNotiReceiveId(List<Long> notiReceiveId);

    List<NotiResponseObject> list(long userUid);

    List<NotiReceive> findAllByUserId(long userId);
}
