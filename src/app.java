
import client.gui.Frame;
import client.socket.ConnectionStarter;
import javax.swing.SwingUtilities;
import server.MainServer;

public class app {
    public static void main(String[] args) {
        app a = new app();
    }
    
    private Frame frame;
    private final String serverName = "localhost";
    private final int port = 16801;
    
    public app() {
        /////// TEMPPPPPPPP ////////
        temp();
        this.frame = new Frame();
        establishServerConnection();
        initGUI();
    }
    
    private void temp() {
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