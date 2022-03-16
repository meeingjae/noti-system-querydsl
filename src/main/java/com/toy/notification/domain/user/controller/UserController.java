package com.toy.notification.domain.user.controller;

import com.toy.notification.domain.user.dto.UserDeleteRequest;
import com.toy.notification.domain.user.service.UserService;
import com.toy.notification.util.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @DeleteMapping
    public ResponseEntity<ResponseStatus> delete(
            @RequestBody UserDeleteRequest request) {

        ResponseStatus response = service.delete(request);

        return new ResponseEntity<ResponseStatus>(
                Arrays.stream(HttpStatus.values())
                        .filter(status -> status.equals(response.getHttpStatus()))
                        .findFirst().get());
    }
}
