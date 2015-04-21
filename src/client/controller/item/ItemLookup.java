package client.controller.item;

import client.model.Item;
import client.view.item.ItemView;

public class ItemLookup extends ItemController {
    private final int id;

    public ItemLookup(int id) {
        this.id = id;
        setComplete(false);
    }
    
    @Override
    public void run() {
        synchronized(this) {
            super.item = getItem();
            init(new ItemView(item.getItem_name(), item.getItem_price()));
            setComplete(true);
        }
        view.print();
        
    }
    
    private Item getItem() {
        return (Item) dao.getByID(id);
    }
}