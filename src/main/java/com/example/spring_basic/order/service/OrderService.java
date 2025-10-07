package com.example.spring_basic.order.service;

import com.example.spring_basic.order.Order;

public interface OrderService {

    // Order 객체 만들어서 반환하는 createOrder 메서드를 구현하세요.
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
