package org.academiadecodigo.javabank.view;


import org.academiadecodigo.javabank.service.Bank;
import org.academiadecodigo.javabank.model.domain.account.Account;

import java.text.DecimalFormat;
import java.util.Set;

public class BalanceView extends AbstractView {

    private DecimalFormat df = new DecimalFormat("#.##");

    @Override
    public void show(Bank bank) {

        System.out.println("\n" + bank.getCustomer(bank.getAccessingCustomerId()).getName() + Messages.VIEW_BALANCE_MESSAGE + "\n");

        Set<Account> accounts = bank.getCustomer(bank.getAccessingCustomerId()).getAccounts();
        for (Account account : accounts) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }

        System.out.println("\n\n" + Messages.VIEW_BALANCE_TOTAL_MESSAGE + df.format(bank.getCustomer(bank.getAccessingCustomerId()).getBalance()));
    }

}

