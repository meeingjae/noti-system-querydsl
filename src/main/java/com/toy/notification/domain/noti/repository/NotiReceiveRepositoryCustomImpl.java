package com.toy.notification.domain.noti.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toy.notification.domain.noti.entity.NotiReceive;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.toy.notification.domain.noti.dto.response.ListNotiResponse.NotiResponseObject;
import static com.toy.notification.domain.noti.entity.QNoti.noti;
import static com.toy.notification.domain.noti.entity.QNotiReceive.notiReceive;

@Repository
@RequiredArgsConstructor
public class NotiReceiveRepositoryCustomImpl implements NotiReceiveRepositoryCustom {

    private final JPAQueryFactory factory;

    @Override
    public List<NotiResponseObject> list(long userUid) {

        //TODO: * join 부분은 완벽히 숙지할 것
        return factory.select(
                // DTO 계층에서 querydsl을 의존하지 않게 하기 위해 NotiResponseObject.class에  @QueryProjection 사용하지 않는다.
                Projections.constructor(
                        NotiResponseObject.class,
                        noti.message,
                        notiReceive.readFlag))
                .from(notiReceive)
                .join(notiReceive.noti, noti)
                .where(notiReceive.userId.eq(userUid))
                .fetch();
    }

    @Override
    public List<NotiReceive> findAllByNotiReceiveId(List<Long> notiReceiveId) {

        return factory.select(notiReceive)
                .from(notiReceive)
                .where(notiReceive.notiReceiveId.in(notiReceiveId))
                .fetch();
    }


    @Override
    public List<NotiReceive> findAllByUserId(long userId) {

        return factory.select(notiReceive)
                .from(notiReceive)
                .where(notiReceive.userId.eq(userId))
                .fetch();
    }
}