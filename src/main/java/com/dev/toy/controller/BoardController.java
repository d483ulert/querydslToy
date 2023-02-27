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
import org.springframework.web.bind.annotation.*;
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

    @PutMapping("/{idx}")
    public ResponseEntity modify(@PathVariable("idx") Long boradIdx, @RequestBody BoardDto boardDto){
        boardService.modify(boradIdx,boardDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{idx}")
    public ResponseEntity read(@PathVariable("idx") Long boardIdx){
        return new ResponseEntity(boardService.read(boardIdx), HttpStatus.OK);
    }

}


