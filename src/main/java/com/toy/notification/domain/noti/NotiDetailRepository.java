package com.toy.notification.domain.noti;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotiDetailRepository extends JpaRepository<NotiDetail, Long> {

}
