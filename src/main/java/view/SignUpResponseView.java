package main.java.view;

public class SignUpResponseView {
    private static final String NOTICE = "안녕~~~ IDS 입니다. 회원가입 정보를 입력해주세요";
    private static final String NAME = "NAME 입력: ";
    private static final String ID = "ID 입력: ";
    private static final String PASSWORD = "PASSWORD 입력: ";
    private static final String AGE = "AGE 입력: ";
    private static final String DISCOUNTINFO = "DiscountInfo 입력(8): ";


    public void printNotice() {
        System.out.println(NOTICE);
    }

    public void printName() {
        System.out.print(NAME);
    }

    public void printId() {
        System.out.print(ID);
    }

    public void printPassword() {
        System.out.print(PASSWORD);
    }

    public void printAge() {
        System.out.print(AGE);
    }

    public void printDiscountInfo() {
        System.out.print(DISCOUNTINFO);
    }
}
