package com.dev.toy.service;

import com.dev.toy.common.ResultDto;
import com.dev.toy.dto.BoardDto;
import com.dev.toy.entity.Board;
import com.dev.toy.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository repository;

    @Transactional
    public ResultDto<BoardDto> BoardList(){
        PageRequest page = PageRequest.of(0,10,Sort.by(Sort.Direction.DESC,"board_idx"));
        Page<Board> boards = repository.findAll(page);

        Page<BoardDto> map = boards.map(board -> new BoardDto(
                board.getBoardIdx(),
                board.getTitle(),
                board.getWriter(),
                board.getContent(),
                board.getView())
        );
        return (ResultDto<BoardDto>) map;
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
