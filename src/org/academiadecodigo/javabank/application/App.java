package org.academiadecodigo.javabank.application;

import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.service.Bank;
import org.academiadecodigo.javabank.model.domain.Customer;
import org.academiadecodigo.javabank.service.AccountManager;

public class App {

    public static void main(String[] args) {

        Bank bank = new Bank();
        AccountManager accountManager = new AccountManager();
        bank.setAccountManager(accountManager);

        Customer c1 = new Customer(1, "Rui");
        Customer c2 = new Customer(2, "Sergio");
        Customer c3 = new Customer(3, "Bruno");
        bank.addCustomer(c1);
        bank.addCustomer(c2);
        bank.addCustomer(c3);

        LoginController loginController = new LoginController(bank);
        loginController.init();
    }
}
