package main.java.controller;

import main.java.dto.SignUpRequestDto;
import main.java.service.SignUpService;

public class SignUpController {
    private final SignUpService signUpService;

    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    public void signUp() {
        SignUpRequestDto signUpRequestDto = signUpService.signUp();
        signUpService.save(signUpRequestDto);
    }
}
