/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.Workers;

import client.gui.ItemsPanel;
import client.gui.Return;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mutualModels.Item;

public class addItemToCart extends ItemLookup {

    public addItemToCart(int id, ItemsPanel panel) {
        super(id, panel);
    }
    
    public addItemToCart(int id, Return panel) {
        super(id, panel);
    }
    
    @Override
    protected void done() {
        try {
            Item item = (Item) get();
            if (panel!= null){
                panel.addItem(item);
            }
            else{
                String label = item.getItem_name() + "\t" + item.getItem_price() + "\t" + item.getItem_id()+"\n";
                rPanel.addLabel(label);
            }   
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(ItemLookup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
