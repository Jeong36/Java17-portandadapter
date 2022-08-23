package com.example.java17sample.member.application.port.out;

import com.example.java17sample.member.domain.Member;

public interface SaveMemberPort {
    void save(Member member);
}
