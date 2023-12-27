package main.java.service;

import java.util.List;
import java.util.Map;
import main.java.dto.DiscountPriceDto;
import main.java.model.DiscountInfo;
import main.java.model.DiscountPrice;
import main.java.model.Member;
import main.java.repository.MemberRepository;

public class CalculateService {
    private final MemberRepository memberRepository = MemberRepository.getInstance();


    public DiscountPriceDto calculate() {
        List<Member> members = memberRepository.getMembers();

        DiscountPrice discountPrice = new DiscountPrice();

        Map<Member, Integer> calculateDiscountPrice = discountPrice.calculateDiscountPrice(members);
        Map<DiscountInfo, Integer> discountFee = discountPrice.getDiscountFee(members);
        return DiscountPriceDto.createDiscountPriceDto(calculateDiscountPrice, discountFee);
    }
}
