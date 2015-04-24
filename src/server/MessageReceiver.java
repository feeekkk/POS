
package server;

import server.model.Client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import mutualModels.Purchase;
import server.model.Request;

public class MessageReceiver implements Runnable {
    private final ObjectInputStream is;
    private final Client client;
    private final MainServer server;
    
    MessageReceiver(MainServer server, Client client) {
        this.server = server;
        this.is = client.getObjectInputStream();
        this.client = client;
    }

    @Override
    public void run() {
        checkForMessageFromClient();
    }
    
    public void checkForMessageFromClient() {
        try {
            Object message;
            Request request = null;
            while((message = is.readObject()) != null) {
                if(message instanceof Integer) {
                    request = new Request(client, message);
                    System.out.println("server: Item lookup request received from client: " + message + " | submitting request to main server.");
                    server.submitRequest(request);
                }
                else if(message instanceof Purchase) {
                    request = new Request(client, message);
                    System.out.println("server: Purchase request received from client: " + message + " | submitting request to main server.");
                }
                else {
                    System.err.println("server: unknown request type");
                }
                server.submitRequest(request);
            }
        } catch ( IOException | ClassNotFoundException ex) {
            Logger.getLogger(MessageReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
