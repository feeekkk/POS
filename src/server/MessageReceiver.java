
package server;

import server.model.Client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.dao.ItemDAO;
import mutualModels.Item;
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
                if(message instanceof Integer) {
                    Request request = new Request(client, message);
                    System.out.println("server: request received from client: " + message + " | submitting request to main server.");
                    server.submitRequest(request);
                    // all temp
                    /*
                    Integer id = (Integer) message;
                    System.out.println("server: received integer. starting item lookup");
                    ItemDAO dao = new ItemDAO();
                    Item item = (Item) dao.getByID(id);
                    System.out.println("server: item found: " + item.getItem_name());
                            */
                }
            }
        } catch ( IOException | ClassNotFoundException ex) {
            Logger.getLogger(MessageReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
