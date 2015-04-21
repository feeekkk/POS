package client.controller;

import client.model.Model;
import client.view.View;

public abstract class Controller implements Runnable {
    protected View view;
    protected Model model;
    private boolean complete;
    
    public void init(Model model, View view) {
        this.view = view;
        this.model = model;
    }
    
    @Override
    public abstract void run();
    
    protected abstract void displayView();
    
    public void setComplete(boolean b) {
        this.complete = b;
    }
    
    public boolean isComplete() {
        return complete;
    }
}