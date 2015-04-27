package server.dao;

import mutualModels.Item;

public class ItemDAO {

    public static Item getByID(int id) {
        return tempGetByID(id);
    }
    
    private static Item tempGetByID(int id) {
        return new Item(id, "Temp", 69.99);
    }
    
    public static void reduceQuantity(int id, int quantity) {
        // to do
    }
    
    public static void increaseQuantity(int id, int quantity) {
        // to do
    }
}