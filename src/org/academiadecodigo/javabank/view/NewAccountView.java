package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.controller.NewAccountController;
import org.academiadecodigo.javabank.service.Bank;

public class NewAccountView extends AbstractView {
    private NewAccountController newAccountController;

    public NewAccountView(NewAccountController newAccountController) {
        this.newAccountController = newAccountController;
    }

    @Override
    public void show(Bank bank) {
        System.out.println("\n" + Messages.MENU_OPEN_ACCOUNT + bank.getCustomer(bank.getAccessingCustomerId()).getName() + " : " + newAccountController.getAccountId());
    }

}
