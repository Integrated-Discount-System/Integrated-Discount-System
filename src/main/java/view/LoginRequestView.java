package main.java.view;

import main.java.utils.Console;
import main.java.validation.LoginValidator;

public class LoginRequestView {
    private final LoginValidator loginValidator;

    public LoginRequestView(LoginValidator loginValidator) {
        this.loginValidator = loginValidator;
    }

    public String readLoginId() {
        return loginValidator.isBlank(Console.readLine());
    }

    public String readPassword() {
        return loginValidator.isBlank(Console.readLine());
    }
}
