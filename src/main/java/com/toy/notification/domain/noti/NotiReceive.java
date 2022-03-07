package com.toy.notification.domain.noti;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NOTI_RECEIVE")
public class NotiReceive {

    @Id
    @GeneratedValue
    @Column(name = "noti_receive_id", nullable = false)
    private long notiReceiveId;

    @Column(name = "noti_id", nullable = false)
    private long notiId;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "read_flag", nullable = false)
    private boolean readFlag;
}
