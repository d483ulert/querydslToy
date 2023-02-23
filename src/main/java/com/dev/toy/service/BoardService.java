package com.dev.toy.service;

import com.dev.toy.dto.BoardDto;
import com.dev.toy.dto.BoardSearchCondition;
import com.dev.toy.entity.Board;
import com.dev.toy.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository repository;

    @Transactional(readOnly = true)
    public Page<BoardDto> boardList(BoardSearchCondition condition, Pageable pageable) {
        return repository.searchBoardList(condition, pageable);
    }


    @Transactional(rollbackFor = Exception.class)
    public void create(BoardDto boardDto) {
        Board board = Board.builder()
                .content(boardDto.getContent())
                .writer(boardDto.getWriter())
                .view(0)
                .title(boardDto.getTitle())
                .create_date(LocalDateTime.now())
                .created_member(boardDto.getWriter())
                .build();
        repository.save(board);
    }

    @Transactional(readOnly = true)
    public Board read(Long board_idx) {
        return repository.getReferenceById(board_idx);
    }

    @Transactional(rollbackFor = Exception.class)
    public void modify(BoardDto boardDto) {
        Board board = repository.getReferenceById(boardDto.getBoard_idx());
        board.update(boardDto);
    }

}
