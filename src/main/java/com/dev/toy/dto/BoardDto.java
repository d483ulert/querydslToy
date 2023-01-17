package com.dev.toy.dto;

import lombok.Data;

@Data
public class BoardDto {
    private Long board_idx;
    private String title;
    private String member_id;
    private String content;
    private int view;

}
