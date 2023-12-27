package main.java.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public enum DiscountInfo {
    NoMatch("매칭 정보 없음", 0),
    KukMinCard("국민카드", 0.2),
    ShinHanCard("신한카드", 0.15),

    KtCarrier("kt", 0.4),
    SktCarrier("skt", 0.3),

    Army("army", 1),

    CollegeTest("collegeTest", 0.2),

    NaverPay("네이버페이", 0.08),
    KakaoPay("카카오페이", 0.08),

    night("night", 0.2),
    group("group", 0.25);

    /**
     * TODO 이벤트 관련 enum 따로 만들어서 관리하기, night/group 등 옮겨야함
     */

    private String discountInfo;
    private double discountPercent;

    DiscountInfo(String discountInfo, double discountPercent) {
        this.discountInfo = discountInfo;
        this.discountPercent = discountPercent;
    }

    public String getDiscountInfo() {
        return discountInfo;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public static DiscountInfo getInstance(String discount) {
        return Arrays.stream(DiscountInfo.values())
                .filter(discountInfo -> discountInfo.discountInfo.equals(discount))
                .findAny()
                .orElse(NoMatch);
    }

    public static Double getMaxDiscountPercent(Map<DiscountInfo, String> discounts) {
        return discounts.entrySet().stream()
                .filter(entry -> entry.getValue().equals("o"))
                .map(Entry::getKey)
                .max(Comparator.comparingDouble(DiscountInfo::getDiscountPercent))
                .orElse(NoMatch)
                .getDiscountPercent();
    }
}
