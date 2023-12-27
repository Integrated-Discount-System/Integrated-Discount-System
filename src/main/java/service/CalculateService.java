package main.java.service;

import java.util.List;
import main.java.model.DiscountPrice;
import main.java.model.Member;
import main.java.repository.MemberRepository;

public class CalculateService {
    private final MemberRepository memberRepository = MemberRepository.getInstance();


    public List<Integer> calculate() {
        List<Member> members = memberRepository.getMembers();

        DiscountPrice discountPrice = DiscountPrice.createDiscountPrice();

        return discountPrice.calculateDiscountPrice(members);

    }
}
