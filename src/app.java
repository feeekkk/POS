import view.gui.Frame;
import java.sql.*;

public class app {

    public static void main(String[] args) {
        Frame f = new Frame();
        Connection conn = null;
           try
           {
               String userName = "root";
               String password = "root";
               String url = "jdbc:mysql://localhost:8889/POS";
               Class.forName ("com.mysql.jdbc.Driver").newInstance ();
               conn = DriverManager.getConnection (url, userName, password);
               System.out.println ("Database connection established");
           }
           catch (Exception e)
           {
               System.err.println ("Cannot connect to database server");
           }
       }
}