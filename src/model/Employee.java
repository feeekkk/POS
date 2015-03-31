package model;

public class Employee extends Model {
    private int id;
    private String first, last, password;
    
    public Employee(int id, String first, String last, String password) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.password = password;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the first
     */
    public String getFirst() {
        return first;
    }

    /**
     * @return the last
     */
    public String getLast() {
        return last;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
    
}
