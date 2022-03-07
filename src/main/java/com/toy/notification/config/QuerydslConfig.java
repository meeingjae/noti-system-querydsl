package com.toy.notification.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
@EnableJpaAuditing
public class QuerydslConfig {

    //TODO : SQLQueryFactory로 Insert 하는 것. SQLQueryFactory class 못 찾음 문제 해결 필요

    @PersistenceContext
    private EntityManager entityManager;

    public QuerydslConfig() {

    }

    @Bean
    public JPAQueryFactory jpaConfiguration() {

        return new JPAQueryFactory(this.entityManager);
    }
}
