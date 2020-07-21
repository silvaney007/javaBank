package org.academiadecodigo.javabank.view;


import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.service.Bank;

public class LoginView extends AbstractView {

    @Override
    public void show(Bank bank) {
        IntegerSetInputScanner scanner = new IntegerSetInputScanner(bank.getCustomerIds());
        scanner.setMessage(Messages.VIEW_LOGIN_MESSAGE);
        scanner.setError(Messages.VIEW_LOGIN_ERROR);
        bank.setAccessingCustomerId(getPrompt().getUserInput(scanner));
    }
}
