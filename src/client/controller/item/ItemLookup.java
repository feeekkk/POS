package client.controller.item;

import client.controller.Worker;
import client.model.Item;
import client.view.gui.ItemsPanel;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import server.dao.ItemDAO;

public class ItemLookup extends Worker {
    private final int id;
    private final ItemsPanel panel;

    public ItemLookup(int id, ItemsPanel panel) {
        this.id = id;
        this.panel = panel;
    }

    @Override
    protected JLabel doInBackground() throws Exception {
        ItemDAO dao = new ItemDAO();
        Item item = (Item) dao.getByID(id);
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