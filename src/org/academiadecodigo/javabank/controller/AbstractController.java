package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.service.Bank;

import java.util.Map;

public abstract class AbstractController implements Controllable {

    protected Bank bank;
    private Map<Integer, Controllable> operationsMap;



    public AbstractController(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }

    public Map<Integer, Controllable> getOperationsMap() {
        return operationsMap;
    }

    public void setOperationsMap(Map<Integer, Controllable> operationsMap) {
        this.operationsMap = operationsMap;
    }

}
