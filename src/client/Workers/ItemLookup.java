package client.Workers;

import client.Workers.Worker;
import client.gui.ItemsPanel;
import client.gui.Return;
import client.socket.MessageReceiver;
import client.socket.MessageSender;
import java.io.ObjectInputStream;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import mutualModels.Item;

public class ItemLookup extends Worker {
    private final Integer id;
    private  ItemsPanel panel;
    private  Return rPanel;

    public ItemLookup(int id, ItemsPanel panel) {
        this.id = id;
        this.panel = panel;
    }
    public ItemLookup(int id, Return panel) {
        this.id = id;
        this.rPanel = panel;
    }

    @Override
    protected Item doInBackground() throws Exception {
        MessageSender.getObjectOutputStream().writeObject(id);
        ObjectInputStream is = MessageReceiver.getObjectInputStream();
        System.out.println("client: sent item lookup request to server and waiting for response");
        Item item = (Item) MessageReceiver.getObjectInputStream().readObject();
        System.out.println("client: received item from server: " + item.getItem_name());
        
        return item;
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