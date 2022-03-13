package com.toy.notification.domain.noti.dto.response;

import com.toy.notification.util.ResponseStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class CreateNotiResponse {

    private final long           createCount;
    private final ResponseStatus status;
}
