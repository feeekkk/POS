

package client.Workers;

import client.gui.OutOfStockPanel;
import client.socket.MessageReceiver;
import client.socket.MessageSender;
import java.io.ObjectInputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import mutualModels.Item;

public class RetrieveOutOfStockItems extends Worker {
    private final OutOfStockPanel panel;
    
    public RetrieveOutOfStockItems(OutOfStockPanel panel) {
        this.panel = panel;
    }

    @Override
    protected LinkedBlockingQueue<Item> doInBackground() throws Exception {
        System.out.println("client: submitting retrieve out of stock items request");
        MessageSender.getObjectOutputStream().writeObject("RETRIEVE-ALL-OUT-OF-STOCK-ITEMS");
        ObjectInputStream is = MessageReceiver.getObjectInputStream();
        LinkedBlockingQueue<Item> list = (LinkedBlockingQueue<Item>) is.readObject();
        
        return list;
    }
    
    protected void done() {
        try {
            System.out.println("client: received all out of stock items from server. sending to gui");
            LinkedBlockingQueue list = (LinkedBlockingQueue) get();
            panel.setList(list);
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(RetrieveAllItems.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
