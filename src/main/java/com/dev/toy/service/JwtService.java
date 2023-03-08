package com.dev.toy.service;

import com.dev.toy.entity.Member;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class JwtService {

    public static final String key = "jisungkey!!!";
    public static final long accessTime = 21600;
    public static final String issuer = "jisung";

   public String createToken(Member member){
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512,key)
                .setHeaderParam("typ","JWT")
                .setSubject(member.getMember_id())
                .setIssuer(issuer)
                .setExpiration(new Date(new Date().getTime()+accessTime))
                .setIssuedAt(new Date())
                .compact();
    }

}
