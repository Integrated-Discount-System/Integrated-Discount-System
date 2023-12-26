package main.java.config;

import main.java.controller.LoginController;
import main.java.controller.SignUpController;
import main.java.service.LoginService;
import main.java.service.SignUpService;
import main.java.validation.LoginValidator;
import main.java.validation.SignUpValidator;
import main.java.view.LoginRequestView;
import main.java.view.LoginResponseView;
import main.java.view.SignUpRequestView;
import main.java.view.SignUpResponseView;

public class Configuration {
    SignUpRequestView signUpRequestView = createSignUpRequestView();
    SignUpResponseView signUpResponseView = new SignUpResponseView();
    SignUpService signUpService = new SignUpService(signUpRequestView, signUpResponseView);

    LoginRequestView loginRequestView = createLoginRequestView();
    LoginResponseView loginResponseView = new LoginResponseView();
    LoginService loginService = new LoginService(loginRequestView, loginResponseView);

    private SignUpRequestView createSignUpRequestView() {
        SignUpValidator signUpValidator = new SignUpValidator();
        return new SignUpRequestView(signUpValidator);
    }

    private LoginRequestView createLoginRequestView() {
        LoginValidator loginValidator = new LoginValidator();
        return new LoginRequestView(loginValidator);
    }

    public SignUpController getSignUpController() {
        return new SignUpController(signUpService);
    }

    public LoginController getLoginController() {
        return new LoginController(loginService);
    }
}
