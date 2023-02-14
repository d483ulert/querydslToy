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

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository repository;

    @Transactional
    public Page<BoardDto> BoardList(BoardSearchCondition condition, Pageable pageable){
        return repository.searchBoardList(condition,pageable);
    }


    @Transactional
    public void Write(BoardDto boardDto){
        Board board = new Board();
        board.builder()
                .content(boardDto.getContent())
                .writer(boardDto.getWriter())
                .view(0)
                .title(boardDto.getTitle());
        repository.save(board);
    }

    @Transactional(readOnly = true)
    public Board Read(Long board_idx){
        return repository.getReferenceById(board_idx);
    }

    @Transactional
    public void Modify(BoardDto boardDto){
        Board board = repository.getReferenceById(boardDto.getBoard_idx());
        board.update(boardDto);
    }
}
