package com.toy.notification.domain.user.entity;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "company_id", nullable = false)
    private long companyId;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "do_not_disturb_flag", nullable = true)
    private Boolean doNotDisturbFlag;

    @QueryProjection
    public User(long userId) {

        this.userId = userId;
    }
}
