package com.inflearn.spring.member;

public class MemberServiceImpl implements MemberService{
    //null point exception -> 구현 객체 선택
    private final MemberRepository memberRepository; //철저히 인터페이스에만 의존

    // 구체적인 책임은 AppConfig가 담당하도록 -> 생성자 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository=memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.finById(memberId);
    }
}
