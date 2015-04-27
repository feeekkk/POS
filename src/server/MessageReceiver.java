
package server;

import server.model.Client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import mutualModels.Employee;
import mutualModels.Purchase;
import mutualModels.Return;
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
            
            while((message = is.readObject()) != null) {
                Request request = null;
                // integer is used for item lookup for now
                if(message instanceof Integer) {
                    request = new Request(client, message);
                    System.out.println("server: Item lookup request received from client: " + message + " | submitting request to main server.");
                }
                // purchase
                else if(message instanceof Purchase) {
                    request = new Request(client, message);
                    System.out.println("server: Purchase request received from client: " + message + " | submitting request to main server.");
                }
                // employee lookup
                else if(message instanceof Employee) {
                    request = new Request(client, message);
                    System.out.println("server: Employee Lookup request received from client: " + message + " | submitting request to main server.");
                }
                // return
                else if(message instanceof Return) {
                    request = new Request(client, message);
                    System.out.println("server: Return request received from client: " + message + " | submitting request to main server.");
                }
                // certain types of requests hide in strings
                else if(message instanceof String) {
                    request = new Request(client, message);
                    System.out.println("server: received string from client: " + message + " | submitting request to main server.");
                }
                else {
                    System.err.println("server: unknown request type");
                }
                if(request != null) {
                    server.submitRequest(request);
                }
            }
        } catch ( IOException | ClassNotFoundException ex) {
            Logger.getLogger(MessageReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
