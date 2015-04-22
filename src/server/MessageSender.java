/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.IOException;
import server.model.Client;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageSender implements Runnable {
    private LinkedBlockingQueue<Client> clients;

    MessageSender(LinkedBlockingQueue<Client> clients) {
        this.clients = clients;
    }

    public void updateClients(LinkedBlockingQueue<Client> list) {
        this.clients.addAll(list);
    }

    @Override
    public void run() {
        // to do
    }
    
    public void sendWelcomeMessage(Client client) {
        try {
            client.getObjectOutputStream().writeObject("hello");
            client.initObjectInputStream();
        } catch (IOException ex) {
            Logger.getLogger(MessageSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
