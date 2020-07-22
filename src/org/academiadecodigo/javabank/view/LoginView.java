package org.academiadecodigo.javabank.view;


import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.javabank.service.CostumerServiceImpl;

public class LoginView extends AbstractView {

    @Override
    public void show(CostumerServiceImpl costumerServiceImpl) {
        IntegerInputScanner scanner = new IntegerInputScanner();
        scanner.setMessage(Messages.VIEW_LOGIN_MESSAGE);
        scanner.setError(Messages.VIEW_LOGIN_ERROR);
        costumerServiceImpl.getAuthServiceIml().authenticate(getPrompt().getUserInput(scanner));
    }
}
