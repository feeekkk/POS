package controller.employee;

import controller.Controller;
import model.Employee;
import view.View;

public class EmployeeController extends Controller {
    protected final Employee employee;

    public EmployeeController(Employee employee) {
        this.employee = employee;
    }
    
    @Override
    protected void displayView() {
        view.display();
    }
    
    protected void init(View view) {
        super.init(employee, view);
    }

    @Override
    public void run() {
    } 
}