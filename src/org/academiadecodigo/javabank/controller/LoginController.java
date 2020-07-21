package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.service.Bank;
import org.academiadecodigo.javabank.view.LoginView;

public class LoginController extends AbstractController {


    private LoginView loginView;
    private MenuController menuController;

    public LoginController(Bank bank) {
        super(bank);
        loginView = new LoginView();
        menuController = new MenuController(bank);
    }

    @Override
    public void init() {
        loginView.show(bank);
        menuController.init();
    }
}
