package com.example.spring_basic.member.service;

import com.example.spring_basic.member.Member;

public interface MemberService {

    // 반환값 형태 | 메서드 이름 | 입력값(형태 변수명)
    void join(Member member);
    Member findMember(Long memberId);

}
