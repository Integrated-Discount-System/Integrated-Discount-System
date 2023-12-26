package main.java.dto;

import java.util.Map;
import main.java.model.DiscountInfo;
import main.java.model.MemberShip;

public class SignUpRequestDto {
    private String name;
    private String loginId;
    private String password;
    private int age;
    private MemberShip membership = MemberShip.Bronze;
    Map<DiscountInfo, String> discounts;


    private SignUpRequestDto(String name, String loginId, String password, int age,
                             Map<DiscountInfo, String> discounts) {
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        this.age = age;
        this.discounts = discounts;
    }

    public static SignUpRequestDto createSignUpRequest(String name, String loginId, String password, int age,
                                                       Map<DiscountInfo, String> discounts) {
        return new SignUpRequestDto(name, loginId, password, age, discounts);
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

    public MemberShip getMembership() {
        return membership;
    }

    public Map<DiscountInfo, String> getDiscounts() {
        return discounts;
    }
}
