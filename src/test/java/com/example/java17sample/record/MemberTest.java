package com.example.java17sample.record;

import com.example.java17sample.member.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemberTest {

    @DisplayName("Record 를 구성하는 값이 같으면 equals 는 true 를 반환합니다.")
    @Test
    void testCase01() {

        final var einstein = new Member("아인슈타인", "서울");
        final var lincoln = new Member("아인슈타인", "서울");

        assertEquals(einstein, lincoln);
    }

    @Test
    void testCase02() {
        final var einstein = new Member("아인슈타인", "서울");
        System.out.println(einstein.address());
        System.out.println(einstein.name());
    }

}