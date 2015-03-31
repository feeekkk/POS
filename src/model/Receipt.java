/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

public class Receipt extends Model{
   
   private int reciept_id, total_cost;
   private  ArrayList<Item> item = new ArrayList<>(); 
   private Employee employee;
}