package com.dev.toy.repository.querydsl;

import com.dev.toy.dto.BoardDto;
import com.dev.toy.dto.BoardSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardRepositoryCustom {

    Page<BoardDto> searchBoardList(BoardSearchCondition condition, Pageable pageable);
}
