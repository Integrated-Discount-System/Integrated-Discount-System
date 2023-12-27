package main.java.controller;

import static main.java.view.output.DiscountCalculateView.printCalculateResult;
import static main.java.view.output.DiscountListView.printDiscountInfo;

import java.util.List;
import main.java.model.Function;
import main.java.model.Member;
import main.java.service.CalculateService;
import main.java.service.MemberService;
import main.java.view.input.FunctionRequestView;
import main.java.view.output.MainView;

public class MainController {
    private final CalculateService calculateService;
    private final MemberService memberService;

    public MainController(CalculateService calculateService, MemberService memberService) {
        this.calculateService = calculateService;
        this.memberService = memberService;
    }

    public void run(FunctionRequestView functionRequestView) {
        List<Member> members = memberService.readMembers();

        while (true) {
            MainView.explainFunction();
            String func = functionRequestView.readFunction();
            if (func.equals(Function.ONE.getFunction())) {
                System.out.println("1");
            }
            if (func.equals(Function.TWO.getFunction())) {
                printDiscountInfo();
            }
            if (func.equals(Function.THREE.getFunction())) {
                printCalculateResult(members, calculateService.calculate());
            }
            if (func.equals(Function.FOUR.getFunction())) {

            }
            if (func.equals(Function.Quit.getFunction())) {
                break;
            }
        }
    }

}
