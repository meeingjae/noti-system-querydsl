package com.toy.notification.domain.noti.repository;

import com.toy.notification.domain.noti.entity.NotiReceive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotiReceiveRepository extends JpaRepository<NotiReceive, Long>, NotiReceiveRepositoryCustom {

}
