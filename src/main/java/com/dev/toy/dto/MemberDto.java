package com.dev.toy.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class MemberDto {

    private Long member_idx;
    private String member_id;
    private String member_name;
    private String member_pw;

    @QueryProjection
    public MemberDto(String member_id, String member_name,String member_pw){
        this.member_id = member_id;
        this.member_name= member_name;
        this.member_pw=member_pw;
    }
}
