package com.inflearn.spring.singleton;

import com.inflearn.spring.AppConfig;
import com.inflearn.spring.member.MemberRepository;
import com.inflearn.spring.member.MemberServiceImpl;
import com.inflearn.spring.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService=ac.getBean("memberService",MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1= memberService.getMemberRepository();
        MemberRepository memberRepository2= orderService.getMemberRepository();

        System.out.println("memberServie -> memberRepository="+memberRepository1);
        System.out.println("orderServie -> memberRepository="+memberRepository2);
        System.out.println("memberRepository="+memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository1);
        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository2);
        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
    }
}
