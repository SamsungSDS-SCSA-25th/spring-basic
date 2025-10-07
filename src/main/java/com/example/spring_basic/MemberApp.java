package com.example.spring_basic;

import com.example.spring_basic.member.Grade;
import com.example.spring_basic.member.Member;
import com.example.spring_basic.member.service.MemberService;

public class MemberApp {

    public static void main(String[] args) {

        // Service 객체 생성
//        MemberService memberService = new MemberServiceImpl();

        // 1차: AppConfig로 만들기
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        // 회원1 생성
        Member m1 = new Member(1L, "Eric", Grade.VIP);
        // 등록
        memberService.join(m1);
        // 찾기
        Member findMember = memberService.findMember(m1.getId());

        // 등록과 찾기가 같은지 확인
        System.out.println("joinMember = " + m1.getName());
        System.out.println("findMember = " + findMember.getName());
        System.out.println((m1.equals(findMember)));

    }
}
