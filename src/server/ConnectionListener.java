
package server;

import server.model.Client;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionListener {
    private ServerSocket ss;
    private final int port;
    private final MainServer server;
    
    public ConnectionListener(MainServer server, int port) {
        this.server = server;
        this.port = port;
        
        try {
            this.ss = new ServerSocket(this.port);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(true) {
            try {
                System.out.println("server: waiting for connection...");
                Socket client = ss.accept();
                initializeCommunication(client);
            } catch (IOException ex) {
                Logger.getLogger(ConnectionListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void initializeCommunication(Socket socket) {
        Client client = new Client(socket);
        server.sendWelcomeMessage(client);
    }
}
