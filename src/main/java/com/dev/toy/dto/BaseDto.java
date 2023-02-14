package com.dev.toy.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseDto {
    private LocalDateTime create_date;
    private LocalDateTime update_data;
    private String created_member;
    private String modified_member;
}
