
import client.gui.Frame;
import client.socket.ConnectionStarter;
import client.socket.MessageSender;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import mutualModels.Employee;
import mutualModels.Item;
import mutualModels.Purchase;
import server.MainServer;

public class app {
    public static void main(String[] args) throws Exception {
        {    
        Connection con = null;
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection("jdbc:mysql://localhost:8889/POS",
                        "root", "root");
                if (!con.isClosed()) {
                    //System.out.println("Successfully connected to "
                            //+ "MySQL server using TCP/IP...");
                    app a = new app();
                }
            } catch (Exception e) {
                System.err.println("Exception: " + e.getMessage());
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                }
            }
        }
    }
    
    private boolean serverOnly = false;
    private boolean clientOnly = false;
    private boolean runTests = true;
    private Frame frame;
    private final String serverName = "localhost";
    private final int port = 16801;
    
    public app() {
        if(serverOnly) {
            //System.out.println("Connection: " + con);
            startServer();
        }
        else if(clientOnly) {
            //System.out.println("Connection: " + con);
            startClient();
        }
        // start server and client
        else {
            //System.out.println("Connection: " + con);
            startServer();
            startClient();
            
            if(runTests) {
                runTests();
            }
        }
    }
    
    private void startClient() {
        this.frame = new Frame();
        establishServerConnection();
        initGUI();
    }
    
    private void startServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MainServer server = new MainServer(serverName, port);
            }
        }).start();
    }
    
    private void establishServerConnection() {
        ConnectionStarter starter = new ConnectionStarter(serverName, port);
    }
    
    private void initGUI() {
        SwingUtilities.invokeLater(frame);
    }
    
    private void runTests() {
        System.out.println("client: beginning tests");
        testPurchases();
    }
    
    private void testPurchases() {
        System.out.println("client: beginning purchase testing");
        ObjectOutputStream out = MessageSender.getObjectOutputStream();
        
        int numTests = 100;
        int numOtherClientsRunningSameTest = 0;

        // lets submit 1000 purchases of 2 items
        LinkedBlockingQueue<Item> list = new LinkedBlockingQueue<>();
        list.add(new Item(1, "", 1.00, 1));
        list.add(new Item(2, "", 1.00, 1));
        
        Employee e = new Employee(1, "test first", "test name", "pass");
        
       double initTotal = 0;
        
        
        while(numTests >= 0) {
            
            Purchase purchase = new Purchase(list, e, 2.00);

            try {
                out.writeObject(purchase);
            } catch (IOException ex) {
                Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            numTests--;
        }
        
        System.out.println("testing finished... compiling results");
        
        double totalSales = 0;
        
        if(totalSales - (numTests * 2) == initTotal) {
            System.out.println("tests correct!");
        }
        else {
            System.err.println("tests incorrect. off by: " + (totalSales - (numTests * 2)));
        }
    }
}