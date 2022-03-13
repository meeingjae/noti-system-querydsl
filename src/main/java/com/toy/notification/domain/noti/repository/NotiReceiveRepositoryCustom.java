package com.toy.notification.domain.noti.repository;

import java.util.List;

import static com.toy.notification.domain.noti.dto.response.ListNotiResponse.NotiResponseObject;

public interface NotiReceiveRepositoryCustom {

    List<NotiResponseObject> list(long userUid);
}
