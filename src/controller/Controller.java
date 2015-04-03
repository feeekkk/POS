package controller;

import model.Model;
import view.View;

public abstract class Controller implements Runnable {
    protected View view;
    protected Model model;
    
    public void init(Model model, View view) {
        this.view = view;
        this.model = model;
    }
    
    @Override
    public abstract void run();
    
    protected abstract void displayView();
}