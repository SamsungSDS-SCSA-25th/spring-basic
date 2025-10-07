package com.example.spring_basic;

import com.example.spring_basic.discount.DiscountPolicy;
import com.example.spring_basic.discount.RateDiscountPolicy;
import com.example.spring_basic.member.repo.MemberRepository;
import com.example.spring_basic.member.repo.MemoryMemberRepository;
import com.example.spring_basic.member.service.MemberService;
import com.example.spring_basic.member.service.MemberServiceImpl;
import com.example.spring_basic.order.service.OrderService;
import com.example.spring_basic.order.service.OrderServiceImpl;

// "DI"
public class AppConfig {

    // MemberService 인터페이스에 대한 구체적인 구현체 값 지정
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // OrderService 인터페이스에 대한 구체적인 구현체 값 지정
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    public DiscountPolicy discountPolicy() {
    // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
