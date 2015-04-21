package server.dao;

import client.model.Item;
import java.util.ArrayList;

public class ItemDAO implements Operations{
    
    public boolean setPrice(int id, double price) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getByID(int id) {
        return new Item(id, "Temp", 69.99);
    }

    @Override
    public Object getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}