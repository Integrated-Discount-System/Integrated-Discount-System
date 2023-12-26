package main.java.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.java.model.DiscountInfo;
import main.java.utils.Console;
import main.java.validation.SignUpValidator;

public class SignUpRequestView {
    private final SignUpValidator signUpValidator;

    public SignUpRequestView(SignUpValidator signUpValidator) {
        this.signUpValidator = signUpValidator;
    }

    public String readName() {
        return signUpValidator.isBlank(Console.readLine());
    }

    public String readLoginId() {
        return signUpValidator.isBlank(Console.readLine());
    }

    public String readPassword() {
        String inputPassword = signUpValidator.isBlank(Console.readLine());
        signUpValidator.checkPasswordLength(inputPassword);
        signUpValidator.ensurePasswordStrength(inputPassword);
        return inputPassword;
    }

    public int readAge() {
        String inputAge = signUpValidator.isBlank(Console.readLine());
        return signUpValidator.isInteger(inputAge);
    }

    public Map<DiscountInfo, String> readDiscountInfo() {
        Map<DiscountInfo, String> userDiscounts = new HashMap<>();
        List<DiscountInfo> requiredDiscounts = DiscountInfo.getRequiredDiscounts();

        for (DiscountInfo discountInfo : requiredDiscounts) {
            String discountType = signUpValidator.isBlank(Console.readLine());
            userDiscounts.put(discountInfo, discountType);
        }
        return userDiscounts;
    }
}
