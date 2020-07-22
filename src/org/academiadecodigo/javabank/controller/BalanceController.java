package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.service.CostumerServiceImpl;
import org.academiadecodigo.javabank.view.BalanceView;

public class BalanceController extends AbstractController {

    private BalanceView balanceView;

    public BalanceController(CostumerServiceImpl costumerServiceImpl) {
        super(costumerServiceImpl);
        balanceView = new BalanceView();
    }

    @Override
    public void init() {
        balanceView.show(costumerServiceImpl);
    }
}
