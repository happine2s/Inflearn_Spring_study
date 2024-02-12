package com.inflearn.spring.order;

import com.inflearn.spring.discount.DiscountPolicy;
import com.inflearn.spring.discount.FixDiscountPolicy;
import com.inflearn.spring.member.Member;
import com.inflearn.spring.member.MemberRepository;
import com.inflearn.spring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository=new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.finById(memberId);
        int discountPrice=discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
