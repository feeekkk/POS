/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.Workers;

import client.gui.ViewAllItemsPanel;
import client.socket.MessageReceiver;
import client.socket.MessageSender;
import java.io.ObjectInputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import mutualModels.Item;

public class RetrieveAllItems extends Worker {
    private ViewAllItemsPanel panel;
    
    public RetrieveAllItems(ViewAllItemsPanel panel) {
        this.panel = panel;
    }

    @Override
    protected LinkedBlockingQueue<Item> doInBackground() throws Exception {
        System.out.println("client: submitting retrieve all items request");
        MessageSender.getObjectOutputStream().writeObject("RETRIEVE-ALL-ITEMS");
        ObjectInputStream is = MessageReceiver.getObjectInputStream();
        LinkedBlockingQueue<Item> list = (LinkedBlockingQueue<Item>) is.readObject();
        
        return list;
    }
    
    protected void done() {
        try {
            System.out.println("client: received all items from server. sending to gui");
            LinkedBlockingQueue list = (LinkedBlockingQueue) get();
            panel.setList(list);
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(RetrieveAllItems.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
