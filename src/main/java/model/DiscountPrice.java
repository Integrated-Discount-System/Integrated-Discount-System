package main.java.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountPrice {
    private Map<Member, Integer> discountPrices; // 예상 결제 금액
    private Map<DiscountInfo, Integer> discountFee; // 할인 금액

    public DiscountPrice() {
        this.discountPrices = new HashMap<>();
        this.discountFee = new HashMap<>();
    }

    public Map<Member, Integer> getDiscountPrices() {
        return Collections.unmodifiableMap(discountPrices);
    }

    public Map<DiscountInfo, Integer> getDiscountFee() {
        return Collections.unmodifiableMap(discountFee);
    }

    public Map<Member, Integer> calculateDiscountPrice(List<Member> members) {
        for (Member member : members) {
            DiscountInfo maxDiscountPercent = DiscountInfo.getMaxDiscountPercent(member.getDiscounts());
            int discountPrice = (int) (member.getFee() - maxDiscountPercent.getDiscountPercent() * member.getFee());
            discountPrices.put(member, discountPrice);
        }
        return discountPrices;
    }

    public Map<DiscountInfo, Integer> getDiscountFee(List<Member> members) {
        for (Member member : members) {
            DiscountInfo maxDiscountPercent = DiscountInfo.getMaxDiscountPercent(member.getDiscounts());
            discountFee.put(maxDiscountPercent, (int) (maxDiscountPercent.getDiscountPercent() * member.getFee()));
        }
        return discountFee;
    }
}
