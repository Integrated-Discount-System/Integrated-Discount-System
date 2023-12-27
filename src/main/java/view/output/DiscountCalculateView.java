package main.java.view.output;

import java.text.NumberFormat;
import java.util.Map;
import main.java.dto.DiscountPriceDto;
import main.java.dto.MembersDto;
import main.java.model.DiscountInfo;
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
    private static final String DISCOUNT = " 할인";
    private static final String DELIMITER = ": ";
    private static final String EMPTY_LINE = "\n";
    private static final String WON = "원";


    // 예상 결제 금액 출력
    public static void printDiscountPrices(DiscountPrice discountPrice) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        Map<Member, Integer> discountPrices = discountPrice.getDiscountPrices();

        for (Map.Entry<Member, Integer> entry : discountPrices.entrySet()) {
            String memberName = entry.getKey().toString();
            String formattedPrice = numberFormat.format(entry.getValue());
            System.out.println(memberName + DELIMITER + formattedPrice + WON);
        }
    }


    public static void printCalculateResult(MembersDto membersDto, DiscountPriceDto discountPriceDto) {
        System.out.println(NOTICE);
        System.out.println(TOTAL_PRICE);
        showOriginPrice(membersDto);
        System.out.print(EMPTY_LINE);

        System.out.println(DISCOUNT_AMOUNT);
        showDiscount(discountPriceDto);

        /**
         * TODO <이벤트 할인 금액> 부터 만들기
         */
        System.out.println(EVENT_DISCOUNT_AMOUNT);


    }

    private static void showOriginPrice(MembersDto membersDto) {
        for (Member member : membersDto.getMembers()) {
            System.out.println(member.getName() + DELIMITER + member.getFee());
        }
    }

    private static void showDiscount(DiscountPriceDto discountPriceDto) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        Map<DiscountInfo, Integer> discountFee = discountPriceDto.getDiscountFee();

        for (Map.Entry<DiscountInfo, Integer> entry : discountFee.entrySet()) {
            String discountInfo = entry.getKey().getDiscountInfo();
            String formattedFee = numberFormat.format(entry.getValue());
            System.out.println(discountInfo + DELIMITER + formattedFee + WON + DISCOUNT);
        }
    }
}
