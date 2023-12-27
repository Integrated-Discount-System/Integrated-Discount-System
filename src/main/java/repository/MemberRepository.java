package main.java.repository;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import main.java.model.DiscountInfo;
import main.java.model.Member;
import main.java.utils.ExcelReader;

public class MemberRepository {
    private static final MemberRepository memberRepository = new MemberRepository();
    private List<Member> members = ExcelReader.readExcel();

    public static MemberRepository getInstance() {
        return memberRepository;
    }

    //    public void save() {
//        ExcelWriter.writeExcel();
//    }

    public List<Member> getMembers() {
//        checkMembers();
        return members;
    }

    // 엑셀 입력 테스트
    private void checkMembers() {
        List<Map<DiscountInfo, String>> collect = members.stream()
                .map(member -> member.getDiscounts())
                .collect(Collectors.toList());

        List<String> collect1 = members.stream()
                .map(member -> member.getName())
                .collect(Collectors.toList());

        for (String name : collect1) {
            System.out.println("name = " + name);
        }

        List<Integer> collect3 = members.stream()
                .map(member -> member.getFee())
                .collect(Collectors.toList());

        for (Integer fee : collect3) {
            System.out.println("fee = " + fee);
        }

        List<String> collect2 = members.stream()
                .map(member -> member.getMembership())
                .collect(Collectors.toList());

        for (String membership : collect2) {
            System.out.println("memberShip = " + membership);
        }

        for (Map<DiscountInfo, String> discountInfoStringMap : collect) {
            for (Entry<DiscountInfo, String> discountInfoStringEntry : discountInfoStringMap.entrySet()) {
                System.out.println("discountInfoStringEntry.getKey() = " + discountInfoStringEntry.getKey());
                System.out.println("discountInfoStringEntry.getValue() = " + discountInfoStringEntry.getValue());
            }
        }
    }

}
