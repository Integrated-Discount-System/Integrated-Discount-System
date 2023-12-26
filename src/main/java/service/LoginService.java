package main.java.service;

import main.java.model.Member;
import main.java.repository.MemberRepository;
import main.java.view.LoginRequestView;
import main.java.view.LoginResponseView;

public class LoginService {
    private final LoginRequestView loginRequestView;
    private final LoginResponseView outputView;
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    public LoginService(LoginRequestView loginRequestView, LoginResponseView outputView) {
        this.loginRequestView = loginRequestView;
        this.outputView = outputView;
    }

    public boolean authenticate() {
        outputView.printNotice();
        outputView.printId();
        String loginId = loginRequestView.readLoginId();
        outputView.printPassword();
        String password = loginRequestView.readPassword();

        Member findMember = memberRepository.findByLoginId(loginId);

        if (findMember.getLoginId().equals(loginId) && findMember.getPassword().equals(password)) {
            outputView.printSuccess(findMember.getName());
            return true;
        }
        outputView.printFail();
        return false;
    }
}
