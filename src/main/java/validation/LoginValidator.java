package main.java.validation;

import main.java.exception.CustomException;

public class LoginValidator {
    private static final String EMPTY_INPUT = "입력값이 빈 값이거나 null 입니다.";

    public String isBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw CustomException.errorMessage(EMPTY_INPUT);
        }
        return input;
    }
}
