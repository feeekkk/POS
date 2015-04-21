
import client.view.gui.Frame;
import java.sql.*;
import javax.swing.SwingUtilities;

public class app {
    public static void main(String[] args) {
        app a = new app();
    }
    
    private Frame frame;
    
    public app() {
        this.frame = new Frame();
        initGUI();
        
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
    
    public void initGUI() {
        SwingUtilities.invokeLater(frame);
    }
}