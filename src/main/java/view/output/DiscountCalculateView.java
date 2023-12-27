package main.java.view.output;

import java.text.NumberFormat;
import java.util.List;
import main.java.model.DiscountPrice;
import main.java.model.Member;

public class DiscountCalculateView {
    private static final String NOTICE = "할인율 계산기 입니다.";
    private static final String TOTAL_PRICE = "<총 금액>";
    private static final String DISCOUNT_AMOUNT = "<할인 금액>";
    private static final String EVENT_DISCOUNT_AMOUNT = "<이벤트 할인 금액>";
    private static final String MEMBERSHIP_BENEFITS = "<멤버십 혜택>";
    private static final String ESTIMATED_PAYMENT_AMOUNT = "<예상 결제 금액>";
    private static final String MEMBERSHIP_UPGRADE_POSSIBILITY = "<멤버십 승급 가능 여부>";
    private static final String DELIMITER = " : ";
    private static final String EMPTY_LINE = "\n";

    public static void formatter(DiscountPrice discountPrice) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        discountPrice.getDiscountPrices().forEach(price -> System.out.println(numberFormat.format(price)));
    }

    public static void printCalculateResult(List<Member> members, List<Integer> calculate) {
        System.out.println(NOTICE);
        System.out.println(TOTAL_PRICE);
        for (Member member : members) {
            System.out.println(member.getName() + DELIMITER + member.getFee());
        }
        System.out.print(EMPTY_LINE);

        /**
         * TODO <할인 금액> 부터 만들기
         */

    }
}
