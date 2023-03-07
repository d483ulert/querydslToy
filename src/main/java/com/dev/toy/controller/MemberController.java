package com.dev.toy.controller;

import com.dev.toy.dto.MemberDto;
import com.dev.toy.dto.MemberRequestDto;
import com.dev.toy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public MemberDto login (@RequestBody MemberRequestDto reqDto){
        return memberService.login(reqDto);
    }

}
