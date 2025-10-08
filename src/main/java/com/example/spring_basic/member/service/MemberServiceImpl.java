package com.example.spring_basic.member.service;

import com.example.spring_basic.member.Member;
import com.example.spring_basic.member.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    // DI 필요함 => Service에서 new로 객체 만들면 곤란
    // 1차: AppConfig로 밖에서 DI
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    // "생성자 주입" DI
    // 밖(AppConfig)에서 생성자 호출로 memberRepo의 구체적인 구현체를 주입해줌 => Service는 service 역할만 충실
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
