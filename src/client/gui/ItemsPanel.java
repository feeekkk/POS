package client.gui;

import client.Workers.ItemLookup;
import java.awt.event.ActionEvent;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.JLabel;
import mutualModels.Item;

public class ItemsPanel extends Parent {
    private final Transaction t;
    private final Button b;
    private int itemX, itemY, itemWidth, itemHeight;
    private final LinkedBlockingQueue<Item> items;

    public ItemsPanel(Frame f, Transaction t) {
        super(f);
        this.t = t;
        this.items = new LinkedBlockingQueue<>();
        
        itemX = 10;
        itemY = 200;
        itemWidth = 200;
        itemHeight = 20;
        
        b = new Button(this, "click to generate an item", 100, 100, 300, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == b) {
            int id = 1;
            new ItemLookup(id, this).execute();
        }
        
    }
    
    public void addLabel(JLabel label) {
        label.setBounds(itemX, itemY, itemWidth, itemHeight);
        itemY += itemHeight + 10;
        super.add(label);
        revalidate();
        repaint();
    }
    
    public void addItem(Item item) {
        synchronized(items) {
            System.out.println("client: adding item to cart: " + item.getItem_name());
            items.add(item);
        }
    }
    
    public void removeItem(Item item) {
        synchronized(items) {
            System.out.println("client: removing item to cart: " + item.getItem_name());
            items.remove(item);
        }
    }
    
    public LinkedBlockingQueue<Item> getItems() {
        synchronized(items) {
            return items;
        }
    }

}
