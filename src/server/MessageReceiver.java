
package server;

import server.model.Client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.model.Item;

public class MessageReceiver implements Runnable {
    private final ObjectInputStream is;
    
    MessageReceiver(MainServer server, Client client) {
        this.is = client.getObjectInputStream();
    }

    @Override
    public void run() {
        checkForMessageFromClient();
    }
    
    public void checkForMessageFromClient() {
        try {
            Object message;
            while((message = is.readObject()) != null) {
                if(message instanceof Item) {
                    // to do
                    System.out.println("server: item request received");
                }
            }
        } catch ( IOException | ClassNotFoundException ex) {
            Logger.getLogger(MessageReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
