package com.dev.toy.repository.querydsl;

import com.dev.toy.dto.BoardDto;
import com.dev.toy.dto.BoardSearchCondition;
import com.dev.toy.entity.QBoard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepositoryImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory factory;

    public BoardRepositoryImpl(JPAQueryFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<BoardDto> searchBoardList(BoardSearchCondition condition) {
        return factory.select(new QBoard())

    }
}
