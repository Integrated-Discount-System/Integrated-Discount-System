package main.java.service;

import main.java.dto.MembersDto;
import main.java.repository.MemberRepository;

public class MemberService {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    public MembersDto readMembers() {
        return MembersDto.createMembersDto(memberRepository.getMembers());
    }
}
