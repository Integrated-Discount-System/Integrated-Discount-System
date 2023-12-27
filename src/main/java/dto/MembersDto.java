package main.java.dto;

import java.util.List;
import main.java.model.Member;

public class MembersDto {
    private List<Member> members;

    private MembersDto(List<Member> members) {
        this.members = members;
    }

    public static MembersDto createMembersDto(List<Member> members) {
        return new MembersDto(members);
    }


    public List<Member> getMembers() {
        return members;
    }
}
