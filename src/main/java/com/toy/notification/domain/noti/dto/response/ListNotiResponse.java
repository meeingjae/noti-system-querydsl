package com.toy.notification.domain.noti.dto.response;

import com.toy.notification.util.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class ListNotiResponse {

    private final List<NotiResponseObject> notiReceiveList;

    private final ResponseStatus status;


    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class NotiResponseObject {

        private String message;

        private boolean readFlag;

        @Override
        public String toString() {

            return "message : " + this.message + ", readFlag : " + this.readFlag;
        }
    }
}
