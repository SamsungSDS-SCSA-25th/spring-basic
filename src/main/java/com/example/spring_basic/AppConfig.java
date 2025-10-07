package com.example.spring_basic;

import com.example.spring_basic.discount.RateDiscountPolicy;
import com.example.spring_basic.member.repo.MemoryMemberRepository;
import com.example.spring_basic.member.service.MemberService;
import com.example.spring_basic.member.service.MemberServiceImpl;
import com.example.spring_basic.order.service.OrderService;
import com.example.spring_basic.order.service.OrderServiceImpl;

// "DI"
public class AppConfig {

    // MemberService 인터페이스에 대한 구체적인 구현체 값 지정
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    // OrderService 인터페이스에 대한 구체적인 구현체 값 지정
    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
    }
}
