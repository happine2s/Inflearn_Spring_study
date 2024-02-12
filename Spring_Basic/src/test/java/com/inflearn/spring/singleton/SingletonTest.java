package com.inflearn.spring.singleton;

import com.inflearn.spring.AppConfig;
import com.inflearn.spring.member.Member;
import com.inflearn.spring.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        //1. 조회: 호출할 때마다 객체를 생성
        MemberService memberService1= appConfig.memberService();
        //2. 조회: 호출할 때마다 객체를 생성
        MemberService memberService2= appConfig.memberService();

        // 참조값이 다른 것을 확인
        System.out.println("memberService1="+memberService1);
        System.out.println("memberService2="+memberService2);

        // memberService1 != memberService2
        Assertions.assertThat(memberService  1).isNotSameAs(memberService2);
    }
}
