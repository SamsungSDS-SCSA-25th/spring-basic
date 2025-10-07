package com.example.spring_basic.order.service;

import com.example.spring_basic.discount.DiscountPolicy;
import com.example.spring_basic.member.Member;
import com.example.spring_basic.member.repo.MemberRepository;
import com.example.spring_basic.order.Order;

public class OrderServiceImpl implements OrderService {

    // DI 필요함 => Service에서 new로 객체 만들면 곤란
    // 1차: AppConfig로 밖에서 DI
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // "생성자 주입" DI
    // 밖(AppConfig)에서 생성자 호출로 memberRepo의 구체적인 구현체를 주입해줌 => Service는 service 역할만 충실
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member findMember = memberRepository.findById(memberId); // 회원정보 조회
        int discountPrice = discountPolicy.discount(findMember, itemPrice); // 할인가격 조회

        return new Order(memberId, itemName, itemPrice, discountPrice); // Order 객체 반환
    }
}
