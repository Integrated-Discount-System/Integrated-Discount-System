package main.java.controller;

import main.java.service.LoginService;

public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public void login() {
        if (loginService.authenticate()) {
            //로그인 이후 로직
        }
    }
}
