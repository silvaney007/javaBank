package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.controller.NewAccountController;
import org.academiadecodigo.javabank.service.CostumerServiceImpl;

public class NewAccountView extends AbstractView {
    private NewAccountController newAccountController;

    public NewAccountView(NewAccountController newAccountController) {
        this.newAccountController = newAccountController;
    }

    @Override
    public void show(CostumerServiceImpl costumerServiceImpl) {
        System.out.println("\n" + Messages.MENU_OPEN_ACCOUNT + costumerServiceImpl.getCustomer(costumerServiceImpl.getAccessingCustomerId()).getName() + " : " + newAccountController.getAccountId());
    }

}
