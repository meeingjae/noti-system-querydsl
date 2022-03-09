package com.toy.notification.domain.user;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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

}