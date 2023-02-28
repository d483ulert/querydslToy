package com.dev.toy.member;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

@SpringBootTest
public class MemberTest {

    public class AuthService{

    }


    @Test
    public void canCreate(){

    }


    @Test
    public void givenInvalidIndThrowIllegalEx(){
        assertThat(thrownEx,instanceOf(IllegalArgumentException.class));
    }

}
