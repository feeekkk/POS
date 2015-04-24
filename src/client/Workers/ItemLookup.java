package client.Workers;

import client.Workers.Worker;
import mutualModels.Item;
import client.gui.ItemsPanel;
import client.socket.MessageReceiver;
import client.socket.MessageSender;
import java.io.ObjectInputStream;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class ItemLookup extends Worker {
    private final Integer id;
    private final ItemsPanel panel;

    public ItemLookup(int id, ItemsPanel panel) {
        this.id = id;
        this.panel = panel;
    }

    @Override
    protected JLabel doInBackground() throws Exception {
        MessageSender.getObjectOutputStream().writeObject(id);
        ObjectInputStream is = MessageReceiver.getObjectInputStream();
        System.out.println("client: sent item lookup request to server and waiting for response");
        Item item = (Item) MessageReceiver.getObjectInputStream().readObject();
        System.out.println("client: received item from server: " + item.getItem_name());
        JLabel label = new JLabel(item.getItem_name());
        return label;
    }
    
    protected void done() {
        try {
            panel.add((JLabel) get());
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(ItemLookup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}