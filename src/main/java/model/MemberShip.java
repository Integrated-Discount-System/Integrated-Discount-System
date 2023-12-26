package main.java.model;

import java.util.Arrays;

public enum MemberShip {
    NoMatch("매칭 정보 없음", 0, 0, 0),
    Bronze("Bronze", 0, 0, 0),
    Silver("Silver", 10000, 0.01, 1000),
    Gold("Gold", 30000, 0.03, 3000),
    Vip("Vip", 50000, 0.05, 5000);

    private String membership;
    private int baseAmount;
    private double discountPercent;
    private int discountPrice;

    MemberShip(String membership, int baseAmount, double discountPercent, int discountPrice) {
        this.membership = membership;
        this.baseAmount = baseAmount;
        this.discountPercent = discountPercent;
        this.discountPrice = discountPrice;
    }

    public static MemberShip getInstance(String membership) {
        return Arrays.stream(MemberShip.values())
                .filter(memberShip -> memberShip.membership == membership)
                .findAny()
                .orElse(NoMatch);
    }
}
