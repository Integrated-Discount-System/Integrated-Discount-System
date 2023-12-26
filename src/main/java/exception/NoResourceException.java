package main.java.exception;

public class NoResourceException extends RuntimeException {
    private static final String PREFIX = "[NoResourceException] ";
    private static final String ERROR_MESSAGE = "찾고자 하는 정보가 존재하지 않습니다.";

    private NoResourceException() {
        super(PREFIX + ERROR_MESSAGE);
    }

    public static NoResourceException errorMessage() {
        return new NoResourceException();
    }
}
