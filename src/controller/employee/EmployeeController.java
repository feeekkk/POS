package controller.employee;

import controller.Controller;
import model.Employee;
import view.EmployeeView;

public class EmployeeController extends Controller {
    private int id;
    protected final Employee employee;

    public EmployeeController(Employee employee, EmployeeView view) {
        super(employee, view);
        this.employee = employee;
    }
    
    @Override
    protected void displayView() {
        view.display();
    }

    @Override
    public void run() {
    } 
}