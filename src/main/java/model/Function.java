package main.java.model;

import java.util.Arrays;

public enum Function {
    NoMatch("Error", "잘못 입력하셨습니다. 다시 입력해주세요."),
    Quit("q", "종료"),
    ONE("1", "이벤트 보기"),
    TWO("2", "할인 목록 보기"),
    THREE("3", "할인률 계산기"),
    FOUR("4", "현재 멤버십 보기");

    private String function;

    private String explain;

    Function(String function, String explain) {
        this.function = function;
        this.explain = explain;
    }

    public String getFunction() {
        return function;
    }

    public String getExplain() {
        return explain;
    }

    public static String getFunction(String func) {
        return Arrays.stream(Function.values())
                .filter(function -> function.getFunction().equals(func))
                .findAny()
                .orElse(NoMatch)
                .getFunction();
    }
}
