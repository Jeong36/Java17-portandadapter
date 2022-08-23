package com.example.java17sample.member.application;

import com.example.java17sample.member.application.port.in.CreateMemberCommand;
import com.example.java17sample.member.application.port.in.CreateMemberUseCase;
import com.example.java17sample.member.application.port.out.SaveMemberPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
class CreateMemberService implements CreateMemberUseCase {

    private final SaveMemberPort saveMemberPort;

    public CreateMemberService(SaveMemberPort saveMemberPort) {
        this.saveMemberPort = saveMemberPort;
    }

    @Override
    public boolean createMember(CreateMemberCommand command) {

        final var id = UUID.randomUUID();
        final var member = command.member(id);
        saveMemberPort.save(member);

        return true;
    }
}
