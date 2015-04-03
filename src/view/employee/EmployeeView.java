package view.employee;

import view.View;

public class EmployeeView extends View{
    private int id;
    private String first, last;
    
    public EmployeeView(int id, String first, String last) {
        this.id = id;
        this.first = first;
        this.last = last;
    }

    @Override
    public void update() {
    }

    @Override
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("First: " + first);
        System.out.println("Last: " + last);
    }
}