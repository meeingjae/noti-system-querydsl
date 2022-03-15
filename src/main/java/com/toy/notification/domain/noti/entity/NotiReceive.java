package com.toy.notification.domain.noti.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Setter
@Entity
@Table(name = "NOTI_RECEIVE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class NotiReceive {

    @Id
    @GeneratedValue
    @Column(name = "noti_receive_id", nullable = false)
    private long notiReceiveId;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "read_flag", nullable = true)
    private Boolean readFlag = false;

    // Noti Message를 가져오기 위해 EAGER로 설정했으나, Noti Message가 필요 없는 상황 발생 시 디버깅 필요
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "noti_id")
    private Noti noti;
}
