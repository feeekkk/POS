/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

public class Item extends Model{
    private String item_name;
    private int item_id;
    private double item_price;
    
    public Item(int id, String name, double price) {
        this.item_id = id;
        this.item_name = name;
        this.item_price = price;
    }

    
    /**
     * @return the item_name
     */
    public String getItem_name() {
        return item_name;
    }

    /**
     * @param item_name the item_name to set
     */
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    /**
     * @return the item_id
     */
    public int getItem_id() {
        return item_id;
    }

    /**
     * @param item_id the item_id to set
     */
    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    /**
     * @return the item_price
     */
    public double getItem_price() {
        return item_price;
    }

    /**
     * @param item_price the item_price to set
     */
    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }

}
