package main.java;

import main.java.config.Configuration;
import main.java.controller.MainController;
import main.java.validation.FunctionValidator;
import main.java.view.input.FunctionRequestView;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        MainController mainController = config.getMainController();

        FunctionRequestView functionRequestView = new FunctionRequestView(new FunctionValidator());
        mainController.run(functionRequestView);
    }
}
