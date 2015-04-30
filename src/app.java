
import client.gui.Frame;
import client.socket.ConnectionStarter;
import client.socket.MessageReceiver;
import client.socket.MessageSender;
import java.io.IOException;
import java.io.ObjectInputStream;
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
        app a = new app();
    }
    
    private boolean serverOnly = false;
    private boolean clientOnly = true;
    private boolean runTests = true;
    private Frame frame;
    private final String serverName = "172.20.10.2";
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
            
        }
    }
    
    private void startClient() {
        this.frame = new Frame();
        establishServerConnection();
        initGUI();
        
        System.out.println("client: run tests check");
            if(runTests) {
                
                runTests();
            }
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
        
        System.out.println("testing over");
    }
    
    private void testPurchases(){
        System.out.println("client: beginning purchase testing");
        ObjectOutputStream out = MessageSender.getObjectOutputStream();
        
        int numTests = 100;
        int numClientsRunningTests = 1;

        // lets submit 1000 purchases of 2 items
        LinkedBlockingQueue<Item> list = new LinkedBlockingQueue<>();
        list.add(new Item(1, "", 1.00, 1));
        list.add(new Item(2, "", 1.00, 1));
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Employee e = frame.getEmployee();
       double initTotal = e.getTotalSales();
        
        
        while(numTests > 0) {
            
            Purchase purchase = new Purchase(list, e, 2.00);

            try {
                out.writeObject(purchase);
            } catch (IOException ex) {
                Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            numTests--;
        }
         try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("client: testing finished... compiling results");
        try {
            out.writeObject(e);
            e = (Employee) MessageReceiver.getObjectInputStream().readObject();
        } catch (IOException ex) {
            Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        double totalSales = e.getTotalSales();
        
        if(totalSales - initTotal==0) {
            System.out.println("client: tests correct!");
        }
        else {
            System.err.println("client: tests incorrect. off by: " + (totalSales - initTotal));
        }
    }
}