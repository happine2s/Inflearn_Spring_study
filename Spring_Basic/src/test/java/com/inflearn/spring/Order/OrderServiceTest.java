package com.inflearn.spring.Order;

import com.inflearn.spring.AppConfig;
import com.inflearn.spring.member.Grade;
import com.inflearn.spring.member.Member;
import com.inflearn.spring.member.MemberService;
import com.inflearn.spring.member.MemberServiceImpl;
import com.inflearn.spring.order.Order;
import com.inflearn.spring.order.OrderService;
import com.inflearn.spring.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeDach(){
        AppConfig appConfig=new AppConfig();
        memberService= appConfig.memberService();
        orderService= appConfig.orderService();
    }

    @Test
    void createOrder(){
       Long memberId=1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order=orderService.createOrder(memberId,"itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
