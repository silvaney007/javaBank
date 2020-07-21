package org.academiadecodigo.javabank.controller.transation;

import org.academiadecodigo.javabank.controller.AbstractController;
import org.academiadecodigo.javabank.service.Bank;
import org.academiadecodigo.javabank.view.AccountTransactionView;

public class WithdrawController extends AbstractController implements TransactionControllable {


    private AccountTransactionView accountTransactionView;

    public WithdrawController(Bank bank) {
        super(bank);
        accountTransactionView = new AccountTransactionView(this);
    }

    @Override
    public void init() {
        accountTransactionView.show(bank);
    }

    @Override
    public void submitTransaction(int accountId, double amount) {
        bank.getAccountManager().withdraw(accountId, amount);
    }
}
