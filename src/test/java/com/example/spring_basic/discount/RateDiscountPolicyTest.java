package com.example.spring_basic.discount;

import com.example.spring_basic.member.Grade;
import com.example.spring_basic.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_discount_o() {
        // given
        Member member = new Member(1L, "m_VIP", Grade.VIP);
        // when
        int discountPrice = rateDiscountPolicy.discount(member, 10000);
        // then
        Assertions.assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 10% 할인 없다.")
    void vip_discount_x() {
        // given
        Member member = new Member(1L, "m_VIP", Grade.BASIC);
        // when
        int discountPrice = rateDiscountPolicy.discount(member, 10000);
        // then
        Assertions.assertThat(discountPrice).isEqualTo(0);
    }

}