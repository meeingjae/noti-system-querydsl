package com.toy.notification.domain.noti;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotiReceiveRepository extends JpaRepository<NotiReceive, Long>, NotiReceiveRepositoryCustom {

}
