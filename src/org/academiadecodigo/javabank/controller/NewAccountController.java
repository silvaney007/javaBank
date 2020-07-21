package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.service.Bank;
import org.academiadecodigo.javabank.model.domain.account.AccountType;
import org.academiadecodigo.javabank.view.NewAccountView;

public class NewAccountController extends AbstractController{

    private int accountId;
    private NewAccountView accountView;

    public NewAccountController(Bank bank) {
        super(bank);
        accountView = new NewAccountView(this);
    }

    @Override
    public void init() {
        accountId = bank.getCustomer(bank.getAccessingCustomerId()).openAccount(AccountType.CHECKING);
        accountView.show(bank);
    }

    public int getAccountId() {
        return accountId;
    }
}
