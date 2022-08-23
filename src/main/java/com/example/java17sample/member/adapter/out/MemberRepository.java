package com.example.java17sample.member.adapter.out;

import com.example.java17sample.member.application.port.out.SaveMemberPort;
import com.example.java17sample.member.domain.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberRepository implements SaveMemberPort {

    @Override
    public void save(Member member) {
        System.out.println(member);
    }
}
