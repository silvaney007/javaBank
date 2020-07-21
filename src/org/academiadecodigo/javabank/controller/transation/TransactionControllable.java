package org.academiadecodigo.javabank.controller.transation;

import org.academiadecodigo.javabank.controller.Controllable;

public interface TransactionControllable extends Controllable {
    void submitTransaction(int accountId, double amount);
}
