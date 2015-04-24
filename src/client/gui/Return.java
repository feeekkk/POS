/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.gui;

import client.Workers.ItemLookup;
import java.awt.event.ActionEvent;
import javax.swing.*;
import mutualModels.Item;

public class Return extends Parent {
    private JTextArea itemArea;
    private JTextField itemInput;
    private Button b;
    private Button go;
    

    public Return(Frame f) {
        super(f, true);
        
        itemArea = new JTextArea("Item name \t Price \t item ID \n");
        itemArea.setBounds(0, 150, this.getWidth(), 200);
        add(itemArea);
        
        itemInput = new JTextField("Enter Item #");
        itemInput.setBounds(290, 100, 140, 50);
        add(itemInput);
        
        b = new Button(this, "click to generate an item", 440, 100, 300, 50);
        go = new Button(this, "Make Return", 500, 500, 100, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Object obj = e.getSource();
        
        if (obj ==b){
            int id = Integer.parseInt(itemInput.getText());
            new ItemLookup(id, this).execute();
        }
    }
    
    public void addLabel(String label){
        itemArea.append(label);
    }
    
    public void addItem(Item item){
        
    }

}
