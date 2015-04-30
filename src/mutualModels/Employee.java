package mutualModels;

public class Employee extends Model {
    private int id;
    private String first, last, password;
    public static double sales;
    
    public Employee(int id, String first, String last, String password, double sales) {
        System.out.println("Employee ID: "+id);
        this.id = id;
        this.first = first;
        this.last = last;
        this.password = password;
        this.sales = sales;
    }

    /**
     * @return the id
     */
    public int getId(int userid) {
        id = userid;
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
    
    public double getSales(){
        return sales;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(String first) {
        this.first = first;
    }

    /**
     * @param last the last to set
     */
    public void setLast(String last) {
        this.last = last;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    public void setSales(double sales){
        this.sales = sales;
    }
    
    
}
