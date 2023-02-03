package com.dev.toy.dto;

import com.dev.toy.entity.BaseEntity;
import com.dev.toy.entity.Board;
import lombok.Data;

@Data
public class BoardDto extends BaseEntity {
    private Long board_idx;
    private String title;
    private String member_id;
    private String content;
    private int view;


    public BoardDto(Board board){
        this.title = board.getTitle();
        this.member_id = board.getMember_id();
        this.content = board.getContent();
        this.view = board.getView();
    }
}
