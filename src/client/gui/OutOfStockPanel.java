/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.gui;

import client.Workers.RetrieveOutOfStockItems;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.JLabel;
import mutualModels.Item;

public class OutOfStockPanel extends Parent{

    public OutOfStockPanel(Frame f) {
        super(f, true);
        
        RetrieveOutOfStockItems worker = new RetrieveOutOfStockItems(this);
        worker.execute();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // this is called by worker. all items are stored in list. display them on gui here
    public void setList(LinkedBlockingQueue<Item> list) {
        Iterator it = list.iterator();
        while(it.hasNext()) {
            Item item = (Item) it.next();
            add(new JLabel(item.getItem_name()));
            System.out.println("client: adding item to gui: " + item.getItem_name());
        }
        System.out.println("client: added all items to gui");
        this.revalidate();
        this.repaint();
    }
    

}
