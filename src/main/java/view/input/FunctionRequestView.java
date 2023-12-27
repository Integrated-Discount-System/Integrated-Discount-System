package main.java.view.input;

import main.java.exception.CustomException;
import main.java.utils.Console;
import main.java.validation.Function;
import main.java.validation.FunctionValidator;

public class FunctionRequestView {
    private final FunctionValidator functionValidator;

    public FunctionRequestView(FunctionValidator functionValidator) {
        this.functionValidator = functionValidator;
    }

    public String readFunction() {
        try {
            String inputFunction = functionValidator.isBlank(Console.readLine());
            String function = Function.getFunction(inputFunction);
            return functionValidator.checkFunction(function);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            return readFunction();
        }
    }
}
