package com.example.spring_basic.discount;

import com.example.spring_basic.member.Member;

public interface DiscountPolicy {

    // 할인금액(int) | 메서드 이름 | 파라미터들
    int discount(Member member, int price);

}
