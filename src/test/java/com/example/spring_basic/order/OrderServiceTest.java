package com.example.spring_basic.order;

import com.example.spring_basic.member.Grade;
import com.example.spring_basic.member.Member;
import com.example.spring_basic.member.service.MemberService;
import com.example.spring_basic.member.service.MemberServiceImpl;
import com.example.spring_basic.order.service.OrderService;
import com.example.spring_basic.order.service.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void creatOrder() {

        Member member = new Member(1L, "Eric", Grade.VIP);

        memberService.join(member); // 회원가입

        Order order = orderService.createOrder(member.getId(), "Tuna", 10000); // 주문생성

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
