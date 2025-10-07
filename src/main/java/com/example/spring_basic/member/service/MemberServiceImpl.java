package com.example.spring_basic.member.service;

import com.example.spring_basic.member.Member;
import com.example.spring_basic.member.repo.MemberRepository;
import com.example.spring_basic.member.repo.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {

    // DI 필요함 => Service에서 new로 객체 만들면 곤란
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
