package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;

public abstract class AbstractView implements Viewable {

    private Prompt prompt;

    public AbstractView(){
        this.prompt = new Prompt(System.in, System.out);
    }

    public Prompt getPrompt() {
        return prompt;
    }

}