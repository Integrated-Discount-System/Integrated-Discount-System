package main.java.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiscountPrice {
    private List<Integer> discountPrices;

    private DiscountPrice() {
        this.discountPrices = new ArrayList<>();
    }

    public static DiscountPrice createDiscountPrice() {
        return new DiscountPrice();
    }

    public List<Integer> getDiscountPrices() {
        return Collections.unmodifiableList(discountPrices);
    }

    public List<Integer> calculateDiscountPrice(List<Member> members) {
        for (Member member : members) {
            Double maxDiscountPercent = DiscountInfo.getMaxDiscountPercent(member.getDiscounts());
            int discountPrice = (int) (member.getFee() - maxDiscountPercent * member.getFee());
            discountPrices.add(discountPrice);
        }
        return discountPrices;
    }
}
