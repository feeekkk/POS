package dao;

import java.util.ArrayList;

/**
 *
 * @author Feek
 */
public interface Operations {
    Object getByID();
    Object getByName();
    ArrayList getAll();
    boolean insert(Object o);
    boolean update(Object o);
    boolean delete(Object o);
}
