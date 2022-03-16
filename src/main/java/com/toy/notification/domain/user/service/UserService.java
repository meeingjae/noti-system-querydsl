package com.toy.notification.domain.user.service;

import com.toy.notification.domain.user.dto.UserDeleteRequest;
import com.toy.notification.util.ResponseStatus;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    ResponseStatus delete(UserDeleteRequest request);
}
