package main.java.dto;

public class LoginRequestDto {
    private String loginId;
    private String password;

    private LoginRequestDto(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }

    public static LoginRequestDto createLoginRequestDto(String loginId, String password) {
        return new LoginRequestDto(loginId, password);
    }
}
