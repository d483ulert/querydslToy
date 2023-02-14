package com.dev.toy.dto;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Data
public class BoardSearchCondition {

    @Nullable
    private String writer;

    @Nullable
    private String title;

}
