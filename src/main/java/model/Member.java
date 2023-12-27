package main.java.model;

import java.time.LocalDate;
import java.util.Map;

public class Member {
    private String name;
    private int fee;
    Map<DiscountInfo, String> discounts;
    private String membership;
    private LocalDate createPayDate;

    private Member(String name, int fee, Map<DiscountInfo, String> discounts, String membership,
                   LocalDate createPayDate) {
        this.name = name;
        this.fee = fee;
        this.discounts = discounts;
        this.membership = membership;
        this.createPayDate = createPayDate;
    }

    public static Member createMember(String name, int age, Map<DiscountInfo, String> discounts,
                                      String membership, LocalDate createPayDate) {
        return new Member(name, age, discounts, membership, createPayDate);
    }


    public String getName() {
        return name;
    }

    public int getFee() {
        return fee;
    }

    public Map<DiscountInfo, String> getDiscounts() {
        return discounts;
    }

    public String getMembership() {
        return membership;
    }

}
