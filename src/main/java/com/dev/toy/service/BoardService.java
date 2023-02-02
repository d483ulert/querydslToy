package com.dev.toy.service;

import com.dev.toy.dto.BoardDto;
import com.dev.toy.entity.Board;
import com.dev.toy.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository repository;

    @Transactional
    public List<Board> BoardList(){
        return repository.findAll(Sort.by(Sort.Direction.DESC,"board_idx"));
    }

    @Transactional
    public void Write(BoardDto boardDto){
        Board board = new Board();
        board.builder()
                .content(boardDto.getContent())
                .writer(boardDto.getMember_id())
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
