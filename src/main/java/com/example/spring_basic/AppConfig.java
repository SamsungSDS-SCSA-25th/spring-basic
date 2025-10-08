package com.example.spring_basic;

import com.example.spring_basic.discount.DiscountPolicy;
import com.example.spring_basic.discount.RateDiscountPolicy;
import com.example.spring_basic.member.repo.MemberRepository;
import com.example.spring_basic.member.repo.MemoryMemberRepository;
import com.example.spring_basic.member.service.MemberService;
import com.example.spring_basic.member.service.MemberServiceImpl;
import com.example.spring_basic.order.service.OrderService;
import com.example.spring_basic.order.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// "DI"
@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()
    // 의문점? 싱글톤이 깨질까? => 안 깨진다. 개쩐다 ㄷㄷ (@Configuration이 알아서 해줌)

    // MemberService 인터페이스에 대한 구체적인 구현체 값 지정
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // OrderService 인터페이스에 대한 구체적인 구현체 값 지정
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
    // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
