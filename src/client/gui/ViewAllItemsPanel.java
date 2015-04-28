/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.gui;

import client.Workers.RetrieveAllItems;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.PatternSyntaxException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import mutualModels.Item;

public class ViewAllItemsPanel extends Parent {
    String[] colomnNames = {"Item ID","Item Name", "Price"};
    JTextField filter = new JTextField();
    TableRowSorter<TableModel> sorter;
    Button go;
    
    public ViewAllItemsPanel(Frame f){
        super(f,true);
        RetrieveAllItems worker = new RetrieveAllItems(this);
        worker.execute();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Object obj = e.getSource();
        if(obj == go){
        String text = filter.getText();
               if (text.length() == 0) {
                 sorter.setRowFilter(null);
               } else {
                 try {
                   sorter.setRowFilter(
                       RowFilter.regexFilter(text));
                 } catch (PatternSyntaxException pse) {
                   System.err.println("Bad regex pattern");
                 }
               }
        }
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
            
            
            System.out.println("client: adding item to gui: " + item.getItem_name());
        }
            TableModel model = new DefaultTableModel(data, colomnNames);
            sorter = new TableRowSorter<TableModel>(model);
         
            JTable table = new JTable(model);
            table.setRowSorter(sorter);
            
            JScrollPane pane = new JScrollPane(table);
            pane.setBounds(0,100, this.getWidth(), 300);
            table.setFillsViewportHeight(true);
            add(pane);
            
            setSearch();
            
       
        System.out.println("client: added all items to gui");
        this.revalidate();
        this.repaint();
    }
    public void setSearch(){
        JLabel search = new JLabel("Enter ID");
            search.setForeground(Color.WHITE);
            search.setFont(new Font("Arial", Font.PLAIN, 24));
            search.setBounds(0, 400, 100, 50);
            
            
            filter.setBounds(100, 400, 100, 50);
            
            go = new Button(this, "Search", 0, 450, 200, 50);
            go.addActionListener(this);
            
            add(search);
            add(filter);
            add(go);
        
    }
    
    
    
    

}
