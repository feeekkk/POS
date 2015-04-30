/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.Workers;

import client.gui.ItemsPanel;
import client.gui.ReturnTransaction;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mutualModels.Item;

public class AddItemToCart extends ItemLookup {

    public AddItemToCart(int id, ItemsPanel panel) {
        super(id, panel);
        //System.out.println("Sending: "+ItemsPanel.itemID);
    }
    
    @Override
    protected void done() {
        try {
            
            Item item = (Item) get();
            System.out.println("client: adding item with id:" + item.getItem_id());
            panel.addItem(item);
        } catch (InterruptedException | ExecutionException ex) {
            //Logger.getLogger(ItemLookup.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("item lookup failed");
        }
    }

}
