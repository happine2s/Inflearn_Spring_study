package com.inflearn.spring;

import com.inflearn.spring.discount.FixDiscountPolicy;
import com.inflearn.spring.member.MemberService;
import com.inflearn.spring.member.MemberServiceImpl;
import com.inflearn.spring.member.MemoryMemberRepository;
import com.inflearn.spring.order.OrderService;
import com.inflearn.spring.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
