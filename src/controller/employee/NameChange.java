package controller.employee;

import model.Employee;
import view.EmployeeView;

public class NameChange extends EmployeeController {
    private String first, last;

    public NameChange(Employee employee, EmployeeView view, String first, String last) {
        super(employee, view);
        
    }
    
    @Override
    public void run() {
        synchronized(employee) {
            employee.setFirst(first);
            employee.setLast(last);
        }
    }
}