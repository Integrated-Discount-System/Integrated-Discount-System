package main.java.validation;

import main.java.exception.CustomException;

public class SignUpValidator {
    private static final int MINIMUM_Length = 8;
    private static final int MAXIMUM_Length = 20;

    private static final String EMPTY_INPUT = "입력값이 빈 값이거나 null 입니다.";
    private static final String IS_NOT_INTEGER = "입력값은 정수여야 합니다.";
    private static final String INVALID_PASSWORD_SIZE = "비밀 번호는 8자리 이상 20자리 이하여야 합니다.";
    private static final String INVALID_PASSWORD_STRENGTH = "비밀번호는 영어 대문자, 소문자, 숫자 각각 1개 이상 포함해야 합니다.";


    public String isBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw CustomException.errorMessage(EMPTY_INPUT);
        }
        return input;
    }

    public int isInteger(String input) {
        if (!isNumeric(input)) {
            throw CustomException.errorMessage(IS_NOT_INTEGER);
        }
        return Integer.parseInt(input);
    }

    private boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String checkPasswordLength(String input) {
        if (MINIMUM_Length < input.length() && input.length() > MAXIMUM_Length) {
            throw CustomException.errorMessage(INVALID_PASSWORD_SIZE);
        }
        return input;
    }

    public String ensurePasswordStrength(String input) {
        boolean hasUpper = false, hasLower = false, hasDigit = false;

        // 문자열을 순회하면서 대문자, 소문자, 숫자가 있는지 확인
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }
            if (Character.isLowerCase(c)) {
                hasLower = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        if (!hasUpper || !hasLower || !hasDigit) {
            throw CustomException.errorMessage(INVALID_PASSWORD_STRENGTH);
        }

        return input;
    }
}
