package com.toy.notification.domain.noti.service;

import com.toy.notification.domain.noti.dto.response.ListNotiResponse;
import com.toy.notification.domain.noti.repository.NotiReceiveRepository;
import com.toy.notification.util.ResponseStatus;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.toy.notification.domain.noti.dto.response.ListNotiResponse.NotiResponseObject;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
public class NotiReceiveServiceImpl implements NotiReceiveService {

    private final NotiReceiveRepository notiReceiveRepository;

    @Override
    public ListNotiResponse list(long userId) {

        List<NotiResponseObject> notiReceiveList = notiReceiveRepository.list(userId);

        ListNotiResponse.ListNotiResponseBuilder result = ListNotiResponse.builder().notiReceiveList(notiReceiveList);

        if (notiReceiveList.isEmpty()) {
            return result
                    .status(new ResponseStatus(NO_CONTENT, "notification message box is empty"))
                    .build();
        }
        return result
                .status(new ResponseStatus(OK, "OK"))
                .build();
    }
}
