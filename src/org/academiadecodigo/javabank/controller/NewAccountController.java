package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.service.CostumerServiceImpl;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.view.NewAccountView;

public class NewAccountController extends AbstractController{

    private int accountId;
    private NewAccountView accountView;

    public NewAccountController(CostumerServiceImpl costumerServiceImpl) {
        super(costumerServiceImpl);
        accountView = new NewAccountView(this);
    }

    @Override
    public void init() {
        accountId = costumerServiceImpl.getCustomer(costumerServiceImpl.getAccessingCustomerId()).openAccount(AccountType.CHECKING);
        accountView.show(costumerServiceImpl);
    }

    public int getAccountId() {
        return accountId;
    }
}
