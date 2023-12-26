package main.java.service;

import java.util.Map;
import main.java.dto.SignUpRequestDto;
import main.java.model.DiscountInfo;
import main.java.repository.MemberRepository;
import main.java.view.SignUpRequestView;
import main.java.view.SignUpResponseView;

public class SignUpService {
    private final SignUpRequestView signUpRequestView;
    private final SignUpResponseView outputView;
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    public SignUpService(SignUpRequestView signUpRequestView, SignUpResponseView outputView) {
        this.signUpRequestView = signUpRequestView;
        this.outputView = outputView;
    }

    public SignUpRequestDto signUp() {
        outputView.printNotice();

        outputView.printName();
        String name = signUpRequestView.readName();

        outputView.printId();
        String loginId = signUpRequestView.readLoginId();

        outputView.printPassword();
        String password = signUpRequestView.readPassword();

        outputView.printAge();
        int age = signUpRequestView.readAge();

        outputView.printDiscountInfo();
        Map<DiscountInfo, String> discountInfo = signUpRequestView.readDiscountInfo();

        return SignUpRequestDto.createSignUpRequest(name, loginId, password, age, discountInfo);
    }

    public void save(SignUpRequestDto signUpRequestDto) {
        memberRepository.save(signUpRequestDto);
    }
}
