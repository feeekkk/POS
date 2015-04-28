
import client.gui.Frame;
import client.socket.ConnectionStarter;
import javax.swing.SwingUtilities;
import server.MainServer;

public class app {
    public static void main(String[] args) {
        app a = new app();
    }
    
    private boolean serverOnly = false;
    private boolean clientOnly = false;
    private Frame frame;
    private final String serverName = "localhost";
    private final int port = 16801;
    
    public app() {
        if(serverOnly) {
            startServer();
        }
        else if(clientOnly) {
            startClient();
        }
        // start server and client
        else {
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