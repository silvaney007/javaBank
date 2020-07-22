package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.service.CostumerServiceImpl;
import org.academiadecodigo.javabank.view.LoginView;

public class LoginController extends AbstractController {


    private LoginView loginView;
    private MenuController menuController;

    public LoginController(CostumerServiceImpl costumerServiceImpl) {
        super(costumerServiceImpl);
        loginView = new LoginView();
        menuController = new MenuController(costumerServiceImpl);
    }

    @Override
    public void init() {
        loginView.show(costumerServiceImpl);
        menuController.init();
    }
}
