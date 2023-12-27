package main.java.controller;

import static main.java.view.output.DiscountCalculateView.printCalculateResult;
import static main.java.view.output.DiscountListView.printDiscountInfo;

import main.java.dto.MembersDto;
import main.java.model.Function;
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
        MembersDto membersDto = memberService.readMembers();

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
                printCalculateResult(membersDto, calculateService.calculate());
            }
            if (func.equals(Function.FOUR.getFunction())) {

            }
            if (func.equals(Function.Quit.getFunction())) {
                break;
            }
        }
    }

}
