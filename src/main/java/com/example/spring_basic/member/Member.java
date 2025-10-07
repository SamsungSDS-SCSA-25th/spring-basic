package com.example.spring_basic.member;

public class Member {

    // 변수 초기화
    private Long id;
    private String name;
    private Grade grade; // enum 사용

    // 생성자
    public Member(Grade grade, String name, Long id) {
        this.grade = grade;
        this.name = name;
        this.id = id;
    }

    // getter & setter
    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
