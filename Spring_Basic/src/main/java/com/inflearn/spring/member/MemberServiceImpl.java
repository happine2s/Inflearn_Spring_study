package com.inflearn.spring.member;

public class MemberServiceImpl implements MemberService{
    //null point exception -> 구현 객체 선택
    private final MemberRepository memberRepository=new MemoryMemberRepository();

    @Override
    public void join(Member member) {

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.finById(memberId);
    }
}
