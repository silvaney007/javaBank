package org.academiadecodigo.javabank.controller.transation;

import org.academiadecodigo.javabank.controller.AbstractController;
import org.academiadecodigo.javabank.service.Bank;
import org.academiadecodigo.javabank.view.AccountTransactionView;

public class DepositController extends AbstractController implements TransactionControllable {

    private AccountTransactionView accountTransactionView;


    public DepositController(Bank bank) {
        super(bank);
        accountTransactionView = new AccountTransactionView(this);
    }

    @Override
    public void init() {
    accountTransactionView.show(bank);
    }

    @Override
    public void submitTransaction(int accountId, double amount) {
        bank.getAccountManager().deposit(accountId, amount);
    }
}
