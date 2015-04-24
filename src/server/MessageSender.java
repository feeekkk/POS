
package server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import server.model.Client;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.model.Request;

public class MessageSender {
    private final ExecutorService service;

    MessageSender() {
        int numThreads = 5;
        this.service = Executors.newFixedThreadPool(numThreads);
    }
    
    public void sendWelcomeMessage(Client client) {
        try {
            client.getObjectOutputStream().writeObject("hello");
            client.initObjectInputStream();
        } catch (IOException ex) {
            Logger.getLogger(MessageSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void submitResponseToBeSent(final Request request) {
        synchronized(service) {
            service.execute(new Runnable() {

                @Override
                public void run() {
                    synchronized(request) {
                        try {
                            Object toWrite = request.getReturnObject();
                            ObjectOutputStream outStream = request.getObjectOutputStream();
                            System.out.println("server: writing " + toWrite + "to " + request.getObjectOutputStream());
                            outStream.writeObject(toWrite);
                        } catch (IOException ex) {
                            Logger.getLogger(MessageSender.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        }
    }

}
