package main.java.exception;

public class ExcelWriteException extends IllegalArgumentException {
    private static final String PREFIX = "[WRITE_ERROR] ";
    private static final String SUFFIX = " 다시 입력해주세요.";

    private ExcelWriteException(String errorMessage) {
        super(PREFIX + errorMessage + SUFFIX);
    }

    public static ExcelWriteException errorMessage(String errorMessage) {
        return new ExcelWriteException(errorMessage);
    }
}
