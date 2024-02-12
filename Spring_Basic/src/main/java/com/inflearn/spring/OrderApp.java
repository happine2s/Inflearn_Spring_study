package com.inflearn.spring;

import com.inflearn.spring.member.Grade;
import com.inflearn.spring.member.Member;
import com.inflearn.spring.member.MemberService;
import com.inflearn.spring.member.MemberServiceImpl;
import com.inflearn.spring.order.Order;
import com.inflearn.spring.order.OrderService;
import com.inflearn.spring.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService=new MemberServiceImpl();
        OrderService orderService=new OrderServiceImpl();

        Long memberId=1L;
        Member member=new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order=orderService.createOrder(memberId,"itemA", 10000);
        System.out.println("order="+order);
        System.out.println("order.calculatePrice="+order.calculatePrice());
    }
}
