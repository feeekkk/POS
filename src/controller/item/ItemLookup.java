package controller.item;

import model.Item;

public class ItemLookup extends ItemController {
    private final int id;

    public ItemLookup(Item item, int id) {
        super(item);
        this.id = id;
    }
    
    @Override
    public void run() {
        getItem();
    }
    
    private Item getItem() {
        return (Item) dao.getByID(id);
    }
}