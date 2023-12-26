package main.java;

import main.java.config.Configuration;
import main.java.controller.LoginController;
import main.java.controller.SignUpController;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        SignUpController signUpController = config.getSignUpController();

//        signUpController.signUp();
        LoginController loginController = config.getLoginController();
        loginController.login();
    }
}
