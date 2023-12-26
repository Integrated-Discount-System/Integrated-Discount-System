package main.java.repository;

import java.util.List;
import main.java.dto.SignUpRequestDto;
import main.java.exception.NoResourceException;
import main.java.model.Member;
import main.java.utils.ExcelReader;
import main.java.utils.ExcelWriter;

public class MemberRepository {
    private static final MemberRepository memberRepository = new MemberRepository();
    private List<Member> members = getMembers();

    public static MemberRepository getInstance() {
        return memberRepository;
    }

    private static List<Member> getMembers() {
        return ExcelReader.readExcel();
    }

    public void save(SignUpRequestDto signUpRequestDto) {
        ExcelWriter.writeExcel(signUpRequestDto);
    }

    public Member findByLoginId(String loginId) {
        return members.stream()
                .filter(member -> member.getLoginId().equals(loginId))
                .findFirst()
                .orElseThrow(() -> NoResourceException.errorMessage());
    }
}
