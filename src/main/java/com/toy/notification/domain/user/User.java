package com.toy.notification.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "company_id", nullable = false)
    private long companyId;
    
    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "do_not_disturb_flag", nullable = true)
    private boolean doNotDisturbFlag;
}
