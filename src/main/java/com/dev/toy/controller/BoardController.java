package com.dev.toy.controller;

import com.dev.toy.common.ResultDto;
import com.dev.toy.dto.BoardDto;
import com.dev.toy.entity.Board;
import com.dev.toy.repository.BoardRepository;
import com.dev.toy.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository repository;

    @PostMapping("")
    public ResultDto<BoardDto> List() {
        return boardService.BoardList();
    }


    @PostConstruct
    public void InitData() {
        Board board = new Board();
        for (int i = 0; i < 30; i++) {
            board.builder()
                    .writer("테스트" + i)
                    .title("테스트" + i)
                    .content("테스트내용" + i)
                    .view(0)
                    .build();
            repository.save(board);
        }
    }
}


