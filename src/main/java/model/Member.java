package main.java.model;

import java.util.Map;

public class Member {
    private String name;
    private String loginId;
    private String password;
    private int age;
    Map<DiscountInfo, String> discounts;
    private MemberShip membership;

    public Member(String name, String loginId, String password, int age, Map<DiscountInfo, String> discounts,
                  MemberShip membership) {
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        this.age = age;
        this.discounts = discounts;
        this.membership = membership;
    }

    public static Member createMember(String name, String loginId, String password, int age,
                                      Map<DiscountInfo, String> discounts,
                                      MemberShip membership) {
        return new Member(name, loginId, password, age, discounts, membership);
    }


    public String getName() {
        return name;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public Map<DiscountInfo, String> getDiscounts() {
        return discounts;
    }

    public MemberShip getMembership() {
        return membership;
    }

    public boolean validateDuplicateLoginId() {
        return false;
    }
}
