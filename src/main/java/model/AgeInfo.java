package main.java.model;

import java.util.Arrays;

public enum AgeInfo {
    Infant("유아", 0, 1, 10000),
    Children("어린이", 2, 12, 30000),
    Adolescents("청소년", 13, 18, 40000),
    Adults("어른", 19, 65, 50000),
    Old("노인", 66, 100, 0);

    private String ageGroup;
    private int minAge;
    private int maxAge;
    private int fee;

    AgeInfo(String ageGroup, int minAge, int maxAge, int fee) {
        this.ageGroup = ageGroup;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.fee = fee;
    }

    public static int getFeeByAge(int age) {
        return Arrays.stream(AgeInfo.values())
                .filter(ageInfo -> age >= ageInfo.minAge && age <= ageInfo.maxAge)
                .findFirst()
                .orElse(Old)
                .getFee();
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public int getFee() {
        return fee;
    }
}

