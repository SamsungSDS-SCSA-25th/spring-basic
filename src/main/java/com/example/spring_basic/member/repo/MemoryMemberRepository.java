package com.example.spring_basic.member.repo;

import com.example.spring_basic.member.Member;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    // id, Member 변수 들어갈 store 객체 초기화
    private static Map<Long, Member> store = new HashMap<>();

    // HashMap에서 put => key, value 넣기
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    // HashMap에서 get => key로 value 뽑기
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
