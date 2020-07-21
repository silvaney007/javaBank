package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.controller.transation.TransactionControllable;
import org.academiadecodigo.javabank.service.Bank;
import org.academiadecodigo.javabank.model.domain.Customer;

public class AccountTransactionView extends AbstractView{

    private TransactionControllable transactionController;


    public AccountTransactionView(TransactionControllable transactionController) {
        this.transactionController = transactionController;
    }

    @Override
    public void show(Bank bank) {
        if (bank.getCustomer(bank.getAccessingCustomerId()).getAccountIds().size() == 0) {
            showNoAccounts();
            return;
        }

        showAccounts(bank);

        transactionController.submitTransaction(scanAccount(bank), scanAmount());

    }




    private void showNoAccounts() {
        System.out.println("\n" + Messages.VIEW_ACCOUNT_TRANSACTION_NOACCOUNT_ERROR);
    }

    private void showAccounts(Bank bank) {
        System.out.println("\n" + Messages.VIEW_ACCOUNT_TRANSACTION_ACCOUNTS_MESSAGE + buildAccountList(bank));
    }

    private String buildAccountList(Bank bank) {

        StringBuilder builder = new StringBuilder();

        for (Integer id : bank.getCustomer(bank.getAccessingCustomerId()).getAccountIds()) {
            builder.append(id);
            builder.append(" ");
        }

        return builder.toString();
    }

    private int scanAccount(Bank bank) {

        Customer customer = bank.getCustomer(bank.getAccessingCustomerId());
        IntegerSetInputScanner scanner = new IntegerSetInputScanner(customer.getAccountIds());
        scanner.setMessage(Messages.VIEW_ACCOUNT_TRANSACTION_ACCOUNTID_MESSAGE);
        scanner.setError(Messages.VIEW_ACCOUNT_TRANSACTION_INVALID_ACCOUNT_ERROR);
        return getPrompt().getUserInput(scanner);
    }

    private double scanAmount() {

        DoubleInputScanner scanner = new DoubleInputScanner();
        scanner.setMessage(Messages.VIEW_ACCOUNT_TRANSACTION_AMOUNT_MESSAGE);
        scanner.setError(Messages.VIEW_ACCOUNT_TRANSACTION_INVALID_AMOUNT_ERROR);
        return getPrompt().getUserInput(scanner);
    }

}
