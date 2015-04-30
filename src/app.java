
import client.gui.Frame;
import client.socket.ConnectionStarter;
import java.sql.*;
import javax.swing.SwingUtilities;
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
}