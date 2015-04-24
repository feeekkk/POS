/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mutualModels;

import java.util.concurrent.LinkedBlockingQueue;

public class Transaction extends Model {
    
    private LinkedBlockingQueue items;
    private Employee employee;
    private double total;

    /**
     * @return the items
     */
    public LinkedBlockingQueue getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(LinkedBlockingQueue items) {
        this.items = items;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
}
