package dao;

import model.Item;

public class ItemDAO {
    
    public static Item getItem(int id) {
        return new Item(0, "Temp item, no DB yet", 0);
    }

}