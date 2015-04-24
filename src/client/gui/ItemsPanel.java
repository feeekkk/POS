package client.gui;

import client.Workers.ItemLookup;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.*;
import mutualModels.Item;
import sun.awt.X11.XConstants;

public class ItemsPanel extends Parent {
    private final Transaction t;
    private final Button b;
    private int itemX, itemY, itemWidth, itemHeight;
    private final LinkedBlockingQueue<Item> items;
    private JTextField itemList, itemInput;
    private JLabel totalLabel;
    private double totalCost;

    public ItemsPanel(Frame f, Transaction t) {
        super(f);
        this.t = t;
        this.items = new LinkedBlockingQueue<>();
        
        itemX = 100;
        itemY = 375;
        itemWidth = 200;
        itemHeight = 12;
        
        //This will be replaced by a screenshot of item table
        itemList = new JTextField();
        itemList.setBounds(100,100,200,200);
        itemList.setBackground(Color.red);
        add(itemList);
        
        itemInput = new JTextField("Enter Item #");
        itemInput.setBounds(190,300,140,50);
        add(itemInput);
        
        b = new Button(this, "click to generate an item", 340, 300, 300, 50);
        
        totalLabel = new JLabel("Total: $" + totalCost);
        totalLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        totalLabel.setBounds(340, 600, 250, 50);
        add(totalLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == b) {
            int id = Integer.parseInt(itemInput.getText());
            new ItemLookup(id, this).execute();
        }
        
    }
    
    public void addLabel(JLabel label) {
        label.setBounds(itemX, itemY, itemWidth, itemHeight);
        itemY += itemHeight + 10;
        super.add(label);
        t.revalidate();
        t.repaint();
    }
    
    public void addItem(Item item) {
        synchronized(items) {
            System.out.println("client: adding item to cart: " + item.getItem_name());
            items.add(item);
            totalCost+=item.getItem_price();
            totalLabel.setText("Total: $" + totalCost);
        }
    }
    
    public void removeItem(Item item) {
        synchronized(items) {
            System.out.println("client: removing item to cart: " + item.getItem_name());
            items.remove(item);
            totalCost-=item.getItem_price();
            totalLabel.setText("Total: $" + totalCost);
           
        }
    }
    
    public LinkedBlockingQueue<Item> getItems() {
        synchronized(items) {
            return items;
        }
    }

}
