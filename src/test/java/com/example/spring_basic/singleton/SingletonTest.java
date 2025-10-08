package com.example.spring_basic.singleton;

import com.example.spring_basic.AppConfig;
import com.example.spring_basic.member.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 단순한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // 객체 생성
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        // 참조값 다른 것 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

    }

}
