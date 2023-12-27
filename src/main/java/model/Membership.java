package main.java.model;

import java.util.Arrays;
import java.util.Comparator;

public enum Membership {
    NoMatch("매칭 정보 없음", 0, 0, 0, "없음"),
    Bronze("Bronze", 0, 0, 0, "없음"),
    Silver("Silver", 10000, 0.01, 1000, "인형"),
    Gold("Gold", 30000, 0.03, 3000, "텀블러"),
    Vip("Vip", 50000, 0.05, 5000, "치킨 기프티콘");

    private String membership;
    private int baseAmount;
    private double savePercent;
    private int savePrice;
    private String gift;

    Membership(String membership, int baseAmount, double savePercent, int savePrice, String gift) {
        this.membership = membership;
        this.baseAmount = baseAmount;
        this.savePercent = savePercent;
        this.savePrice = savePrice;
        this.gift = gift;
    }

    public String getMembership() {
        return membership;
    }

    public int getBaseAmount() {
        return baseAmount;
    }

    public static Membership getInstance(int cumulativeAmount) {
        return Arrays.stream(Membership.values())
                .filter(membership -> cumulativeAmount >= membership.baseAmount)
                .sorted(Comparator.comparingInt(Membership::getBaseAmount))
                .findFirst()
                .orElse(NoMatch);
    }


    public static String getMembership(int cumulativeAmount) {
        return Arrays.stream(Membership.values())
                .filter(membership -> cumulativeAmount >= membership.baseAmount)
                .sorted(Comparator.comparingInt(Membership::getBasePrice).reversed())
                .findFirst()
                .orElse(NoMatch)
                .getMembership();
    }


    public static Double getSavePercent(Membership mem) {
        return Arrays.stream(Membership.values())
                .filter(membership -> membership.equals(mem))
                .map(membership -> membership.savePercent)
                .findFirst()
                .orElse(NoMatch.savePercent);
    }


    public static Integer getSavePrice(Membership mem) {
        return Arrays.stream(Membership.values())
                .filter(membership -> membership.equals(mem))
                .map(membership -> membership.savePrice)
                .findFirst()
                .orElse(NoMatch.savePrice);
    }

    private static int getBasePrice(Membership string) {
        return Arrays.stream(Membership.values())
                .filter(membership -> string == membership)
                .map(membership -> membership.baseAmount)
                .findFirst()
                .orElse(NoMatch.baseAmount);
    }


    public static String getGift(Membership string) {
        return Arrays.stream(Membership.values())
                .filter(membership -> string == membership)
                .map(membership -> membership.gift)
                .findFirst()
                .orElse(NoMatch.gift);
    }
}
