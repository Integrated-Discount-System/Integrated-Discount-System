package main.java.service;

import java.util.List;
import main.java.model.Member;
import main.java.repository.MemberRepository;

public class MemberService {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    public List<Member> readMembers() {
        return memberRepository.getMembers();
    }
}
