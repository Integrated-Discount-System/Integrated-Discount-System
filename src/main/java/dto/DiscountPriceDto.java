package main.java.dto;

import java.util.Collections;
import java.util.Map;
import main.java.model.DiscountInfo;
import main.java.model.Member;

public class DiscountPriceDto {
    private Map<Member, Integer> discountPrices; // 예상 결제 금액

    private Map<DiscountInfo, Integer> discountFee; // 할인 금액

    private DiscountPriceDto(Map<Member, Integer> discountPrices, Map<DiscountInfo, Integer> discountFee) {
        this.discountPrices = discountPrices;
        this.discountFee = discountFee;
    }

    public static DiscountPriceDto createDiscountPriceDto(Map<Member, Integer> discountPrices,
                                                          Map<DiscountInfo, Integer> discountFee) {
        return new DiscountPriceDto(discountPrices, discountFee);
    }

    public Map<Member, Integer> getDiscountPrices() {
        return Collections.unmodifiableMap(discountPrices);
    }

    public Map<DiscountInfo, Integer> getDiscountFee() {
        return Collections.unmodifiableMap(discountFee);
    }
}
