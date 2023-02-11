package com.dev.toy.repository.querydsl;

import com.dev.toy.dto.BoardDto;
import com.dev.toy.dto.BoardSearchCondition;
import com.dev.toy.dto.QBoardDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.dev.toy.entity.QBoard.board;
import static org.aspectj.util.LangUtil.isEmpty;

@Repository
public class BoardRepositoryImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory factory;

    public BoardRepositoryImpl(JPAQueryFactory factory) {
        this.factory = factory;
    }

    @Override
    public Page<BoardDto> searchBoardList(BoardSearchCondition condition, Pageable pageable) {
        List<BoardDto> content =  factory
                .select(new QBoardDto(
                        board.title,
                        board.writer,
                        board.content,
                        board.view))
                .from(board)
                .where(
                        writerEq(condition.getWriter()),
                        titleEq(condition.getTitle())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(content,pageable,content.size());
    }


    private BooleanExpression titleEq(String title) {
        return isEmpty(title) ? null : board.title.eq(title);
    }

    private BooleanExpression writerEq(String writer) {
        return isEmpty(writer) ? null : board.writer.eq(writer);
    }
}
