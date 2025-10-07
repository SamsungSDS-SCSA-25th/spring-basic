package com.example.spring_basic.order.service;

import com.example.spring_basic.discount.DiscountPolicy;
import com.example.spring_basic.discount.FixDiscountPolicy;
import com.example.spring_basic.member.Member;
import com.example.spring_basic.member.repo.MemberRepository;
import com.example.spring_basic.member.repo.MemoryMemberRepository;
import com.example.spring_basic.order.Order;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member findMember = memberRepository.findById(memberId); // 회원정보 조회
        int discountPrice = discountPolicy.discount(findMember, itemPrice); // 할인가격 조회

        return new Order(memberId, itemName, itemPrice, discountPrice); // Order 객체 반환
    }
}
