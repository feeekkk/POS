package client.controller.item;

import client.model.Item;
import client.view.item.ItemView;

public class ItemPriceChange extends ItemController {
    private final double price;
    
    public ItemPriceChange(Item item, double price) {
        super(item);
        
        this.price = price;
    }
    
    public void run() {
        synchronized(item) {
            dao.setPrice(item.getItem_id(), price);
            
            init(new ItemView(item.getItem_name(), item.getItem_price()));
        }
    }
}
