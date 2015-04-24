package client.gui;

import client.Workers.ItemLookup;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ItemsPanel extends Parent {
    private final Transaction t;
    private final Button b;
    private int itemX, itemY, itemWidth, itemHeight;

    public ItemsPanel(Frame f, Transaction t) {
        super(f);
        this.t = t;
        
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
    
    public void add(JLabel label) {
        label.setBounds(itemX, itemY, itemWidth, itemHeight);
        itemY += itemHeight + 10;
        super.add(label);
        revalidate();
        repaint();
    }

}
