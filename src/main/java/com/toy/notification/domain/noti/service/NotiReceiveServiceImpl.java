package com.toy.notification.domain.noti.service;

import com.toy.notification.domain.noti.dto.request.UpdateNoti;
import com.toy.notification.domain.noti.dto.response.DeleteNotiResponse;
import com.toy.notification.domain.noti.dto.response.ListNotiResponse;
import com.toy.notification.domain.noti.dto.response.NotiResponse;
import com.toy.notification.domain.noti.entity.NotiReceive;
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

    @Override
    public DeleteNotiResponse delete(UpdateNoti request) {

        //검사 로직은 생략
        notiReceiveRepository.deleteAllById(request.getNotiReceiveIds());

        return DeleteNotiResponse.builder().status(new ResponseStatus(OK, "deleted")).build();
    }

    @Override
    public NotiResponse update(UpdateNoti request) {

        List<NotiReceive> notiReceiveList = notiReceiveRepository.findAllByNotiReceiveId(request.getNotiReceiveIds());

        notiReceiveList.forEach(notiReceive -> notiReceive.setReadFlag(true));

        notiReceiveList = notiReceiveRepository.saveAll(notiReceiveList);

        return NotiResponse.builder()
                .count(notiReceiveList.size())
                .status(new ResponseStatus(OK, "update success"))
                .build();
    }

}
