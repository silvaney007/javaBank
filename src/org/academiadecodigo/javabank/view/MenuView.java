package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.controller.MenuController;
import org.academiadecodigo.javabank.service.CostumerServiceImpl;

public class MenuView extends AbstractView {

    private MenuController menuController;

    public MenuView(MenuController menuController) {
        this.menuController = menuController;
    }

    @Override
    public void show(CostumerServiceImpl costumerServiceImpl) {
        MenuInputScanner mainMenu = new MenuInputScanner(UserOptions.getMessages());
        mainMenu.setError(Messages.VIEW_MAIN_ERROR);
        mainMenu.setMessage(Messages.VIEW_MAIN_MESSAGE);
        menuController.setMainMenu(mainMenu);
    }
}
