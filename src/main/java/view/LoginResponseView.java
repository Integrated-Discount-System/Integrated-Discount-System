package main.java.view;

public class LoginResponseView {
    private static final String NOTICE = "로그인 정보를 입력해주세요";
    private static final String ID = "ID 입력: ";
    private static final String PASSWORD = "PASSWORD 입력: ";
    private static final String SUCCESS = "환영합니다. %s님";
    private static final String FAIL = "ID 혹은 Password가 일치하지 않습니다. 다시 입력해주세요.";

    public void printNotice() {
        System.out.println(NOTICE);
    }

    public void printId() {
        System.out.print(ID);
    }

    public void printPassword() {
        System.out.print(PASSWORD);
    }

    public void printSuccess(String name) {
        System.out.println(String.format(SUCCESS, name));
    }

    public void printFail() {
        System.out.println(FAIL);
    }
}
