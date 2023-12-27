package main.java.view.output;

import main.java.model.DiscountInfo;

public class DiscountListView {
    private static final String NOTICE = "할인 목록 리스트입니다.";
    private static final String DELIMITER = " : ";
    private static final String PERCENT = "%";

    private static final String EMPTY_LINE = "\n";

    public static void printDiscountInfo() {
        System.out.println(NOTICE);
        for (DiscountInfo discountInfo : DiscountInfo.values()) {
            if (discountInfo != DiscountInfo.NoMatch) {
                System.out.println(
                        discountInfo.getDiscountInfo() + DELIMITER + (discountInfo.getDiscountPercent() * 100)
                                + PERCENT);
            }
        }
        System.out.print(EMPTY_LINE);
    }
}
