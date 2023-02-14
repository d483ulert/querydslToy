package com.dev.toy.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardDto extends BaseDto {
    private Long board_idx;
    private String title;
    private String writer;
    private String content;
    private Integer view;
    private Integer page;
    private Integer size;


    @QueryProjection
    public BoardDto (String title, String writer, String content, Integer view){
        this.title = title;
        this.writer = writer;
        this.content= content;
        this.view = view;
    }

}
