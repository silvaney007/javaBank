package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.service.CostumerServiceImpl;

import java.util.Map;

public abstract class AbstractController implements Controllable {

    protected CostumerServiceImpl costumerServiceImpl;
    private Map<Integer, Controllable> operationsMap;



    public AbstractController(CostumerServiceImpl costumerServiceImpl) {
        this.costumerServiceImpl = costumerServiceImpl;
    }

    public CostumerServiceImpl getCostumerServiceImpl() {
        return costumerServiceImpl;
    }

    public Map<Integer, Controllable> getOperationsMap() {
        return operationsMap;
    }

    public void setOperationsMap(Map<Integer, Controllable> operationsMap) {
        this.operationsMap = operationsMap;
    }

}
