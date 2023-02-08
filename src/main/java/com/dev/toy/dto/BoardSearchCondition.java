package com.dev.toy.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BoardSearchCondition {
    private String writer;
    private LocalDateTime writeTitme;
    private Integer view;

}
