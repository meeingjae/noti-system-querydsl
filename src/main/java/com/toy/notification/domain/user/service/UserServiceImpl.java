package com.toy.notification.domain.user.service;

import com.toy.notification.domain.noti.entity.NotiReceive;
import com.toy.notification.domain.noti.repository.NotiReceiveRepository;
import com.toy.notification.domain.user.dto.UserDeleteRequest;
import com.toy.notification.domain.user.entity.User;
import com.toy.notification.domain.user.repository.UserRepository;
import com.toy.notification.util.ResponseStatus;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository        userRepository;
    private final NotiReceiveRepository notiReceiveRepository;

    @Override
    public ResponseStatus delete(UserDeleteRequest request) {

        User user = userRepository.findByCompanyAndUserId(request.getCompanyId(), request.getUserId());

        if (user != null) {
            List<NotiReceive> notiReceiveList = notiReceiveRepository.findAllByUserId(user.getUserId());
            notiReceiveRepository.deleteAll(notiReceiveList);

            return new ResponseStatus(OK, "deleted");
        } else {
            return new ResponseStatus(NOT_FOUND, "user not exist");
        }
    }
}
