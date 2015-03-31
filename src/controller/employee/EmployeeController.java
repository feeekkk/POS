package controller.employee;

import controller.Controller;
import model.Employee;
import view.EmployeeView;

public class EmployeeController extends Controller {
    private int id;

    public EmployeeController(Employee employee, EmployeeView view) {
        super(employee, view);
    }
    
    @Override
    protected void displayView() {
        view.display();
    }

    @Override
    public void run() {
    } 
}