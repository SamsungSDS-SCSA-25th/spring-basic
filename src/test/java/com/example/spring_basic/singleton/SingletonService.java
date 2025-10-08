package com.example.spring_basic.singleton;

public class SingletonService {

    // 1. static 영역에 인스턴스 하나만 존재
    private static final SingletonService instance = new SingletonService();

    // 2. private 생성자로 밖에서 new 사용 금지
    private SingletonService() {
    }

    // 3. 싱글톤 객체 조회 => 항상 같은 인스턴스 반환
    public static SingletonService getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("싱글톤 객체 호출");
    }

}
