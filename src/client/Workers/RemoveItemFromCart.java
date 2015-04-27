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

public class RemoveItemFromCart extends ItemLookup{
    public RemoveItemFromCart(int id, ItemsPanel panel) {
        super(id, panel);
    }
    
    @Override
    protected void done() {
        try {
            Item item = (Item) get();
            panel.removeItem(item);   
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(ItemLookup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
