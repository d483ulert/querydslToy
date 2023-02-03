package com.dev.toy.controller;

import com.dev.toy.common.ResultDto;
import com.dev.toy.dto.BoardDto;
import com.dev.toy.entity.Board;
import com.dev.toy.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    public ResultDto<BoardDto> List(){
        return boardService.BoardList();
    }
}

