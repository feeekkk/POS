package dao;

import java.util.ArrayList;

public interface Operations {
    Object getByID(int id);
    Object getByName(String name);
    ArrayList getAll();
    boolean insert(Object o);
    boolean update(Object o);
    boolean delete(Object o);
}
