package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.controller.transation.DepositController;
import org.academiadecodigo.javabank.controller.transation.WithdrawController;
import org.academiadecodigo.javabank.service.Bank;
import org.academiadecodigo.javabank.view.MenuView;
import org.academiadecodigo.javabank.view.UserOptions;

import java.util.HashMap;
import java.util.Map;

public class MenuController extends AbstractController {

    private MenuView menuView;
    private MenuInputScanner mainMenu;

    public MenuController(Bank bank){
        super(bank);
        menuView = new MenuView(this);
    }

    @Override
    public void init() {
        menuView.show(bank);
        setOperationsMap(buildOperationsMap());
        menuLoop();
    }

    private void menuLoop() {

        int userChoice = menuView.getPrompt().getUserInput(mainMenu);

        if (userChoice == UserOptions.QUIT.getOption()) {
            return;
        }

        getOperationsMap().get(userChoice).init();
        menuLoop();
    }


    private Map<Integer, Controllable> buildOperationsMap() {
        Map<Integer, Controllable> map = new HashMap<>();
        map.put(UserOptions.GET_BALANCE.getOption(), new BalanceController(bank));
        map.put(UserOptions.DEPOSIT.getOption(), new DepositController(bank));
        map.put(UserOptions.WITHDRAW.getOption(), new WithdrawController(bank));
        map.put(UserOptions.OPEN_ACCOUNT.getOption(), new NewAccountController(bank));
        return map;
    }

    public void setMainMenu(MenuInputScanner mainMenu) {
        this.mainMenu = mainMenu;
    }
}
