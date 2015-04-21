package controller.employee;

import model.Employee;
import view.employee.EmployeeView;

public class NameChange extends EmployeeController {
    private String first, last;

    public NameChange(Employee employee) {
        super(employee);
        
        init(new EmployeeView(employee.getId(), employee.getFirst(), employee.getLast()));
    }
    
    @Override
    public void run() {
        employee.setFirst(first);
        employee.setLast(last);
    }
}