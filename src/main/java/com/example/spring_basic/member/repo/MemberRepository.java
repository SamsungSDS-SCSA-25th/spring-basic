package com.example.spring_basic.member.repo;

import com.example.spring_basic.member.Member;

public interface MemberRepository {

    // 반환값 형태 | 메서드 이름 | 입력값(형태 변수명)
    void save(Member member);
    Member findById(Long memberId);

}
