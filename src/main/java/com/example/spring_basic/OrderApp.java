package com.example.spring_basic;

import com.example.spring_basic.member.Grade;
import com.example.spring_basic.member.Member;
import com.example.spring_basic.member.service.MemberService;
import com.example.spring_basic.member.service.MemberServiceImpl;
import com.example.spring_basic.order.Order;
import com.example.spring_basic.order.service.OrderService;
import com.example.spring_basic.order.service.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        // Service 객체 생성 => client가 사용함
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        // 1차: AppConfig로 만들기
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Member member = new Member(1L, "Eric", Grade.VIP);

        memberService.join(member); // 회원가입

        Order order = orderService.createOrder(member.getId(), "Tuna", 10000); // 주문생성
        System.out.println("order = " + order);
        System.out.println(order.calculatePrice());
    }

}
