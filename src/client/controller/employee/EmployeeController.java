package client.controller.employee;

import client.controller.Controller;
import client.model.Employee;
import client.view.View;

public class EmployeeController extends Controller {
    protected final Employee employee;

    public EmployeeController(Employee employee) {
        this.employee = employee;
    }
    
    @Override
    protected void displayView() {
        view.print();
    }
    
    protected void init(View view) {
        super.init(employee, view);
    }

    @Override
    public void run() {
    } 
}