package com.toy.notification.domain.noti.repository;

import com.toy.notification.domain.noti.entity.Noti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotiRepository extends JpaRepository<Noti, Long>, NotiRepositoryCustom {

}
