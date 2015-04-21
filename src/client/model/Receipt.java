/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.model;

import java.util.ArrayList;

public class Receipt extends Model{
   
   private int receipt_id, total_cost;
   private  ArrayList<Item> item = new ArrayList<>(); 
   private Employee employee;

    /**
     * @return the receipt_id
     */
    public int getReciept_id() {
        return receipt_id;
    }

    /**
     * @param reciept_id the receipt_id to set
     */
    public void setReciept_id(int reciept_id) {
        this.receipt_id = reciept_id;
    }

    /**
     * @return the total_cost
     */
    public int getTotal_cost() {
        return total_cost;
    }

    /**
     * @param total_cost the total_cost to set
     */
    public void setTotal_cost(int total_cost) {
        this.total_cost = total_cost;
    }

    /**
     * @return the item
     */
    public ArrayList<Item> getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(ArrayList<Item> item) {
        this.item = item;
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
   
   
}