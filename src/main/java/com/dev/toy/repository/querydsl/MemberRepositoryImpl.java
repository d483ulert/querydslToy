package com.dev.toy.repository.querydsl;

import com.dev.toy.repository.querydsl.MemberRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory factory;

    public MemberRepositoryImpl(JPAQueryFactory factory) {
        this.factory = factory;
    }

}
