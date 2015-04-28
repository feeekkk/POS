/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.gui;

import client.Workers.RetrieveAllItems;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import mutualModels.Item;

public class ViewAllItemsPanel extends Parent {
    String[] colomnNames = {"Item ID","Item Name", "Price"};
    
    public ViewAllItemsPanel(Frame f){
        super(f,true);
        RetrieveAllItems worker = new RetrieveAllItems(this);
        worker.execute();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // this is called by worker. all items are stored in list. display them on gui here
    public void setList(LinkedBlockingQueue<Item> list) {
        Iterator it = list.iterator();
        int i = 0;
        Object[][] data = new Object[list.size()][3];
        while(it.hasNext()) {
            Item item = (Item) it.next();
            data[i][0]=item.getItem_id();
            data[i][1]= item.getItem_name();
            data[i][2]= item.getItem_price();
            
            i++;
         
            JTable table = new JTable(data, colomnNames);
            JScrollPane pane = new JScrollPane(table);
            pane.setBounds(0,100, this.getWidth(), this.getHeight());
            table.setFillsViewportHeight(true);
            add(pane);
            System.out.println("client: adding item to gui: " + item.getItem_name());
        }
        
       
        System.out.println("client: added all items to gui");
        this.revalidate();
        this.repaint();
    }

}
