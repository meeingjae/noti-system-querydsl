package com.toy.notification.domain.noti;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NOTI")
public class Noti {

    @Id
    @Column(name = "noti_id", nullable = false)
    private long notiId;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "message", nullable = false)
    private String message;
}
