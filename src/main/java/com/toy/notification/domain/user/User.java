package com.toy.notification.domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private long userId;
}
