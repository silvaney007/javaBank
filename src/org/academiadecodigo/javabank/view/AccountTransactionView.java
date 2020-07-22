package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.controller.transation.TransactionControllable;
import org.academiadecodigo.javabank.service.CostumerServiceImpl;
import org.academiadecodigo.javabank.model.Customer;

public class AccountTransactionView extends AbstractView{

    private TransactionControllable transactionController;


    public AccountTransactionView(TransactionControllable transactionController) {
        this.transactionController = transactionController;
    }

    @Override
    public void show(CostumerServiceImpl costumerServiceImpl) {
        if (costumerServiceImpl.getCustomer(costumerServiceImpl.getAccessingCustomerId()).getAccountIds().size() == 0) {
            showNoAccounts();
            return;
        }

        showAccounts(costumerServiceImpl);

        transactionController.submitTransaction(scanAccount(costumerServiceImpl), scanAmount());

    }




    private void showNoAccounts() {
        System.out.println("\n" + Messages.VIEW_ACCOUNT_TRANSACTION_NOACCOUNT_ERROR);
    }

    private void showAccounts(CostumerServiceImpl costumerServiceImpl) {
        System.out.println("\n" + Messages.VIEW_ACCOUNT_TRANSACTION_ACCOUNTS_MESSAGE + buildAccountList(costumerServiceImpl));
    }

    private String buildAccountList(CostumerServiceImpl costumerServiceImpl) {

        StringBuilder builder = new StringBuilder();

        for (Integer id : costumerServiceImpl.getCustomer(costumerServiceImpl.getAccessingCustomerId()).getAccountIds()) {
            builder.append(id);
            builder.append(" ");
        }

        return builder.toString();
    }

    private int scanAccount(CostumerServiceImpl costumerServiceImpl) {

        Customer customer = costumerServiceImpl.getCustomer(costumerServiceImpl.getAccessingCustomerId());
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
