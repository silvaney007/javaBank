package org.academiadecodigo.javabank.controller.transation;

import org.academiadecodigo.javabank.controller.AbstractController;
import org.academiadecodigo.javabank.service.CostumerServiceImpl;
import org.academiadecodigo.javabank.view.AccountTransactionView;

public class WithdrawController extends AbstractController implements TransactionControllable {


    private AccountTransactionView accountTransactionView;

    public WithdrawController(CostumerServiceImpl costumerServiceImpl) {
        super(costumerServiceImpl);
        accountTransactionView = new AccountTransactionView(this);
    }

    @Override
    public void init() {
        accountTransactionView.show(costumerServiceImpl);
    }

    @Override
    public void submitTransaction(int accountId, double amount) {
        costumerServiceImpl.getAccountServiceIml().withdraw(accountId, amount);
    }
}
