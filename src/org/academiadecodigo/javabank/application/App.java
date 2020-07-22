package org.academiadecodigo.javabank.application;

import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.service.AccountServiceImpl;
import org.academiadecodigo.javabank.service.CostumerServiceImpl;
import org.academiadecodigo.javabank.model.Customer;

public class App {

    public static void main(String[] args) {

        CostumerServiceImpl costumerServiceImpl = new CostumerServiceImpl();
        AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
        costumerServiceImpl.setAccountServiceIml(accountServiceImpl);

        Customer c1 = new Customer(1, "Rui");
        Customer c2 = new Customer(2, "Sergio");
        Customer c3 = new Customer(3, "Bruno");
        costumerServiceImpl.addCustomer(c1);
        costumerServiceImpl.addCustomer(c2);
        costumerServiceImpl.addCustomer(c3);

        LoginController loginController = new LoginController(costumerServiceImpl);
        loginController.init();
    }
}
