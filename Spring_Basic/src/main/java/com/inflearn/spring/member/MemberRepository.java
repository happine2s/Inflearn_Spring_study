package com.inflearn.spring.member;

public interface MemberRepository {
    void save(Member member);
    Member finById(Long memberId);
}
