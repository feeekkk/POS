package controller;

import java.util.ArrayList;
import model.Employee;
import view.EmployeeView;

public class EmployeeController extends Controller {
    private static final ArrayList<Employee> employees = new ArrayList();
    private int id;
    private Employee _model;

    public EmployeeController(int id) {
        this.id = id;
    }
    
    @Override
    protected void init() {
        _model = getEmployee(id);
        model = _model;

        synchronized(model) {
            view = new EmployeeView(_model.getId(), _model.getFirst(), _model.getLast());
            displayView();
        }
    }
    
    @Override
    protected void displayView() {
        view.display();
    }

    @Override
    public void run() {
        init();
    }
    
    public Employee getEmployee(int id) {
        for(Employee e : employees) {
            if(e.getId() == id) {
                return e;
            }
        }
        
        return getEmployeeDB(id);
    }
    
    private Employee getEmployeeDB(int id) {
        System.out.println("DB METHOD");
        Employee e = new Employee(id, "first", "last", "pass");
        employees.add(e);
        return e;
    }
}