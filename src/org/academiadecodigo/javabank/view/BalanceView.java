package org.academiadecodigo.javabank.view;


import org.academiadecodigo.javabank.service.CostumerServiceImpl;
import org.academiadecodigo.javabank.model.account.Account;

import java.text.DecimalFormat;
import java.util.Set;

public class BalanceView extends AbstractView {

    private DecimalFormat df = new DecimalFormat("#.##");

    @Override
    public void show(CostumerServiceImpl costumerServiceImpl) {

        System.out.println("\n" + costumerServiceImpl.getCustomer(costumerServiceImpl.getAccessingCustomerId()).getName() + Messages.VIEW_BALANCE_MESSAGE + "\n");

        Set<Account> accounts = costumerServiceImpl.getCustomer(costumerServiceImpl.getAccessingCustomerId()).getAccounts();
        for (Account account : accounts) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }

        System.out.println("\n\n" + Messages.VIEW_BALANCE_TOTAL_MESSAGE + df.format(costumerServiceImpl.getCustomer(costumerServiceImpl.getAccessingCustomerId()).getBalance()));
    }

}

