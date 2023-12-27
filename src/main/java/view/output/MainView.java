package main.java.view.output;

import main.java.model.Function;

public class MainView {
    private static final String NOTICE = "안녕하세요. Integrated Discount System 입니다. 기능을 선택해주세요.";

    private static final String COMMA = ". ";

    public static void explainFunction() {
        System.out.println(NOTICE);
        System.out.println(Function.ONE.getFunction() + COMMA + Function.ONE.getExplain());
        System.out.println(Function.TWO.getFunction() + COMMA + Function.TWO.getExplain());
        System.out.println(Function.THREE.getFunction() + COMMA + Function.THREE.getExplain());
        System.out.println(Function.FOUR.getFunction() + COMMA + Function.FOUR.getExplain());
        System.out.println(Function.Quit.getFunction() + COMMA + Function.Quit.getExplain());
    }
}
