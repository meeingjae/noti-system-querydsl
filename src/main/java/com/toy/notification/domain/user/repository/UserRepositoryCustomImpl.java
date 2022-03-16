package com.toy.notification.domain.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toy.notification.domain.user.entity.QUser;
import com.toy.notification.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final JPAQueryFactory factory;

    /**
     * @see:https://jojoldu.tistory.com/516 (Exist Query 개선 참고)
     */
    @Override
    public boolean existByUserId(long id) {

        Integer exist = factory.selectOne()
                .from(QUser.user)
                .where(QUser.user.userId.eq(id))
                .fetchFirst();

        return exist != null;
    }

    @Override
    public List<Long> findSendAvailableUserIds(long companyId, List<String> userName) {

        return factory.select(
                //Projections.bean 테스트
                //                                Projections.bean(
                //                                        Long.class,       // --> Long Type Bean을 Initialization 할 수 없다는 에러..
                //                                        QUser.user.userId)) //Long 타입의 userId 목록만 불러온다
                //                                .from(QUser.user)
                //                                .where(QUser.user.companyId.eq(companyId),
                //                                        QUser.user.userName.in(userName))
                //                                .fetch();
                QUser.user.userId) //Long 타입의 userId 목록만 불러온다
                .from(QUser.user)
                .where(QUser.user.companyId.eq(companyId),
                        QUser.user.userName.in(userName),
                        QUser.user.doNotDisturb.eq(User.DoNotDisturb.OFF.isFlag()))
                .fetch();
    }

    @Override
    public User findByCompanyAndUserId(long companyId, long userId) {

        return factory.select(QUser.user)
                .from(QUser.user)
                .where(QUser.user.companyId.eq(companyId), QUser.user.userId.eq(userId))
                .fetchFirst();
    }
}