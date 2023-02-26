package com.dev.toy.controller;

import com.dev.toy.dto.BoardDto;
import com.dev.toy.dto.BoardSearchCondition;
import com.dev.toy.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/list")
    public Page<BoardDto> list(@Valid @RequestBody BoardSearchCondition condition,
                               @PageableDefault(sort="boardIdx", direction = Sort.Direction.DESC)  Pageable pageable) {
        return boardService.boardList(condition,pageable);
    }

    @PostMapping("")
    public ResponseEntity create(@Valid @RequestBody BoardDto boardDto) {
        boardService.create(boardDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}


