package main.java.validation;

import main.java.exception.CustomException;
import main.java.model.Function;

public class FunctionValidator {
    private static final String EMPTY_INPUT = "입력값이 빈 값이거나 null 입니다.";
    private static final String IS_NOT_INTEGER = "입력값은 정수여야 합니다.";
    private static final String VALID_FUNCTION = "입력값이 올바르지 않습니다.";


    public String isBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw CustomException.errorMessage(EMPTY_INPUT);
        }
        return input;
    }

    public String checkFunction(String function) {
        if (function.equals(Function.NoMatch.getFunction())) {
            throw CustomException.errorMessage(VALID_FUNCTION);
        }
        return function;
    }
}
