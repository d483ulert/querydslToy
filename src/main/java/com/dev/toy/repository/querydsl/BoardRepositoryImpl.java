package com.dev.toy.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepositoryImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory factory;

    public BoardRepositoryImpl(JPAQueryFactory factory) {
        this.factory = factory;
    }

}
