package main.java.model;

import java.util.Arrays;
import java.util.List;

public enum DiscountInfo {
    NoMatch("매칭 정보 없음", 0),
    KukMinCard("국민카드", 0.2),
    ShinHanCard("신한카드", 0.15),

    KtCarrier("kt", 0.4),
    SktCarrier("skt", 0.3),

    Army("army", 1),
    Old("old", 1),

    CollegeTest("collegeTest", 0.2),

    NaverPay("네이버페이", 0.08),
    KakaoPay("카카오페이", 0.08),

    night("night", 0.2),
    group("group", 0.25);

    private String discountInfo;
    private double discountPercent;

    DiscountInfo(String discountInfo, double discountPercent) {
        this.discountInfo = discountInfo;
        this.discountPercent = discountPercent;
    }

    public static List<DiscountInfo> getRequiredDiscounts() {
        return Arrays.asList(
                DiscountInfo.KukMinCard,
                DiscountInfo.ShinHanCard,
                DiscountInfo.KtCarrier,
                DiscountInfo.SktCarrier,
                DiscountInfo.Army,
                DiscountInfo.CollegeTest,
                DiscountInfo.NaverPay,
                DiscountInfo.KakaoPay
        );
    }

    public static DiscountInfo getInstance(String discount) {
        return Arrays.stream(DiscountInfo.values())
                .filter(discountInfo -> discountInfo.discountInfo == discount)
                .findAny()
                .orElse(NoMatch);
    }

    public String getDiscountInfo() {
        return discountInfo;
    }
}
