package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.service.Bank;
import org.academiadecodigo.javabank.view.BalanceView;

public class BalanceController extends AbstractController {

    private BalanceView balanceView;

    public BalanceController(Bank bank) {
        super(bank);
        balanceView = new BalanceView();
    }

    @Override
    public void init() {
        balanceView.show(bank);
    }
}
