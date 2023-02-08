package com.dev.toy.repository.querydsl;

import com.dev.toy.dto.BoardDto;
import com.dev.toy.dto.BoardSearchCondition;

import java.util.List;

public interface BoardRepositoryCustom {

    List<BoardDto> searchBoardList(BoardSearchCondition condition);
}
