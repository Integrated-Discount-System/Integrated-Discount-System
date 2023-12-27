package main.java.config;

import main.java.controller.MainController;
import main.java.service.CalculateService;
import main.java.service.MemberService;

public class Configuration {
    MainController mainController = createMainController();

    private MainController createMainController() {
        CalculateService calculateService = new CalculateService();
        MemberService memberService = new MemberService();
        return new MainController(calculateService, memberService);
    }


    public MainController getMainController() {
        return mainController;
    }
}
