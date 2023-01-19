package com.dev.toy.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory factory;

    public MemberRepositoryImpl(JPAQueryFactory factory) {
        this.factory = factory;
    }

}
