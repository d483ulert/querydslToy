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
import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository repository;

    @Transactional
    public Page<BoardDto> boardList(BoardSearchCondition condition, Pageable pageable) {
        return repository.searchBoardList(condition, pageable);
    }


    @Transactional
    public void create(BoardDto boardDto) {
        Board board = new Board();
        Board.builder()
                .content(boardDto.getContent())
                .writer(boardDto.getWriter())
                .view(0)
                .title(boardDto.getTitle());
        repository.save(board);
    }

    @Transactional(readOnly = true)
    public Board read(Long board_idx) {
        return repository.getReferenceById(board_idx);
    }

    @Transactional
    public void modify(BoardDto boardDto) {
        Board board = repository.getReferenceById(boardDto.getBoard_idx());
        board.update(boardDto);
    }

    @PostConstruct
    public void initData() {
        for (int i = 0; i < 30; i++) {
            Board board = Board.builder()
                    .writer("테스트" + i)
                    .title("테스트" + i)
                    .content("테스트내용" + i)
                    .view(0)
                    .build();
            repository.save(board);
        }
    }
}
