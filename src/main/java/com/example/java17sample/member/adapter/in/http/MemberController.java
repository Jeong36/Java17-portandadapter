package com.example.java17sample.member.adapter.in.http;

import com.example.java17sample.member.application.port.in.CreateMemberCommand;
import com.example.java17sample.member.application.port.in.CreateMemberUseCase;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping
public class MemberController {

    private final CreateMemberUseCase service;

    public MemberController(CreateMemberUseCase service) {
        this.service = service;
    }

    @PostMapping("/member")
    public ResponseEntity<MemberResponse> request(
        @Valid @RequestBody MemberRequest payload) {

        MemberRequest test = new MemberRequest("", "", 1123);

        // 유효성 체크
        // dto 유효성 - 생성자 객체 유효성 체크를 해도됨. (O)

        // 불변식(invariants) 체크
        // 도메인 로직 - 생성자 객체 유효성 체크를 해도됨. (X)

        CreateMemberCommand command = payload.command();
        boolean result = service.createMember(command);
        return ResponseEntity.ok(new MemberResponse(result, "Hello, Java 17"));
    }

    record SomeRequest(@NotNull String name) {

    }

    record MemberRequest(
        @NotEmpty(message = "`name`을 입력해 주세요") String name,
        @Length(min = 10, message = "`address`의 길이는 최소 10자리 이상이어야 합니다.") String address,
        @Max(value = 30, message = "`age`는 최대 30을 넘을 수 없습니다.") int age
    ) {
        // private static final RecordValidator<MemberRequest> validator = new RecordValidator<>();

        MemberRequest(String name, String address, int age) {
            this.name = name;
            this.address = address;
            this.age = age;

            //validator.validateSelf(this);
        }

        public CreateMemberCommand command() {
            return new CreateMemberCommand(name, address);
        }
    }

    record MemberResponse(
        boolean status,
        String message
    ) {
    }

    class MemberTest {
        private final String name;

        public MemberTest(String name) {
            this.name = name;
        }

        // Generated !
        public String getName() {
            return name;
        }
    }
}
