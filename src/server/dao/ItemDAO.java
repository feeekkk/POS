package server.dao;

import java.util.concurrent.LinkedBlockingQueue;
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
    
    public static LinkedBlockingQueue<Item> retrieveAll() {
        LinkedBlockingQueue<Item> list = new LinkedBlockingQueue();
        // to do
        list.add(tempGetByID(1));
        list.add(tempGetByID(2));
        list.add(tempGetByID(3));
        return list;
    }
    
    public static LinkedBlockingQueue<Item> retrieveAllOutOfStock() {
        LinkedBlockingQueue<Item> list = new LinkedBlockingQueue();
        // to do
        list.add(tempGetByID(1));
        list.add(tempGetByID(2));
        list.add(tempGetByID(3));
        return list;
    }
}