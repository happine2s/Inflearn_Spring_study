package com.inflearn.spring.xml;

import com.inflearn.spring.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class xmlAppContext {
    @Test
    void xmlAppContext(){
        GenericXmlApplicationContext ac=new GenericXmlApplicationContext("appConfig.xml");

        MemberService memberService=ac.getBean("memberService",MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

}

