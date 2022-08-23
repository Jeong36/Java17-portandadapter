package com.example.java17sample.member.application.port.in;

import com.example.java17sample.member.domain.Member;

import java.util.UUID;

public record CreateMemberCommand(
    String name,
    String address) {

    public Member member(UUID memberId) {
        return new Member(memberId, name, address);
    }
}
