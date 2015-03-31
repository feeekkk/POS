package controller;

import model.Model;
import view.View;

public abstract class Controller implements Runnable {
    protected View view;
    protected Model model;
    
    protected abstract void init();
    
    protected abstract void displayView();
}