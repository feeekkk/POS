/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewShipmentPanel extends Parent{
    
    private Button add;
    private JTextField itemID;
    private JTextField itemName;
    private JTextField price;

    public NewShipmentPanel(Frame f) {
        super(f, true);
        init();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    
    public void init(){
        JLabel idLabel = new JLabel("ID");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        idLabel.setForeground(Color.WHITE);
        idLabel.setBounds(450, 100, 100, 50);
        
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(450, 150, 200, 50);
        
        JLabel priceLabel = new JLabel("Price");
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setBounds(450, 200, 100, 50);
        
        itemID = new JTextField();
        itemID.setBounds(550, 100, 100, 50);
        
        itemName = new JTextField();
        itemName.setBounds(550, 150, 100, 50);
        
        price = new JTextField("$");
        price.setBounds(550, 200, 100, 50);
        
        add = new Button(this, "Add", 550, 250, 100, 50);
        
        add(idLabel);
        add(nameLabel);
        add(priceLabel);
        add(itemID);
        add(itemName);
        add(price);
        add(add);
    }

}
