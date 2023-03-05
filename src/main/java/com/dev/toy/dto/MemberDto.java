package com.dev.toy.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class MemberDto {

    private Long member_idx;
    private String member_id;
    private String member_name;
    private String member_pw;

}
