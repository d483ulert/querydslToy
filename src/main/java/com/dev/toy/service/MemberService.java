package com.dev.toy.service;

import com.dev.toy.dto.MemberDto;
import com.dev.toy.dto.MemberRequestDto;
import com.dev.toy.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {


    private final JwtService jwtService;

    private final MemberRepository repository;

    public MemberDto login(MemberRequestDto reqDto){
       MemberDto memberDto = new MemberDto();


        return memberDto;
    }


}
