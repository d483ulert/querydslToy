package com.dev.toy.dto;

import com.dev.toy.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto extends BaseEntity {
    private Long board_idx;
    private String title;
    private String writer;
    private String content;
    private int view;

}
