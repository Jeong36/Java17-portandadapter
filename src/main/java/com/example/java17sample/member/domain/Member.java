package com.example.java17sample.member.domain;

import java.util.UUID;

public class Member {

    private final UUID id;
    private String name;
    private String address;

    public Member(UUID id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
