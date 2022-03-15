package com.toy.notification.domain.noti.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class UpdateNoti {

    @NotEmpty
    private final List<Long> notiReceiveIds;
}
