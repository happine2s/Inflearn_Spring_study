package com.inflearn.spring.discount;

import com.inflearn.spring.member.Member;

public interface DiscountPolicy {
    // @return은 할인 대상 금액
    int discount(Member member, int price);
}
