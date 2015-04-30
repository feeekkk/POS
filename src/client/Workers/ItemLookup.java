package client.Workers;

import client.gui.ItemsPanel;
import client.gui.ReturnTransaction;
import client.socket.MessageReceiver;
import client.socket.MessageSender;
import java.io.ObjectInputStream;
import mutualModels.Item;

public class ItemLookup extends Worker {
    protected final Integer id;
    protected  ItemsPanel panel;
    protected  ReturnTransaction rPanel;

    public ItemLookup(int id, ItemsPanel panel) {
        this.id = id;
        this.panel = panel;
    }
    public ItemLookup(int id, ReturnTransaction panel) {
        this.id = id;
        this.rPanel = panel;
    }

    @Override
    protected Item doInBackground() throws Exception {
        MessageSender.getObjectOutputStream().writeObject(id);
        ObjectInputStream is = MessageReceiver.getObjectInputStream();
        System.out.println("client: sent item lookup request to server and waiting for response");
        Object o = MessageReceiver.getObjectInputStream().readObject();
        System.out.println("object type received: " + o.getClass().getName());
        Item item = (Item) o;
        System.out.println("client: received item from server: " + item.getItem_name());
        
        return item;
    }
}