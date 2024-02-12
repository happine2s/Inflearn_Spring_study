package com.inflearn.spring;

import com.inflearn.spring.discount.DiscountPolicy;
import com.inflearn.spring.discount.FixDiscountPolicy;
import com.inflearn.spring.discount.RateDiscountPolicy;
import com.inflearn.spring.member.MemberRepository;
import com.inflearn.spring.member.MemberService;
import com.inflearn.spring.member.MemberServiceImpl;
import com.inflearn.spring.member.MemoryMemberRepository;
import com.inflearn.spring.order.OrderService;
import com.inflearn.spring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
