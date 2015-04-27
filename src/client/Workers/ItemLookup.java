package client.Workers;

import client.gui.ItemsPanel;
import client.gui.Return;
import client.socket.MessageReceiver;
import client.socket.MessageSender;
import java.io.ObjectInputStream;
import mutualModels.Item;

public class ItemLookup extends Worker {
    protected final Integer id;
    protected  ItemsPanel panel;
    protected  Return rPanel;

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
}