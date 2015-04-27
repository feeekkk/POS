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
            String label = item.getItem_name() + "\t" + item.getItem_price() + "\t" + item.getItem_id()+"\n";
            if (panel!= null){
            panel.addLabel(label);
            panel.addItem(item);
            }
            else{
                rPanel.addLabel(label);
            }   
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(ItemLookup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
