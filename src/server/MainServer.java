/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import server.model.Client;
import java.util.concurrent.LinkedBlockingQueue;

public class MainServer {
    public static void main(String[] args) {
        MainServer server = new MainServer("localhost", 16801);
    }
    
    private final LinkedBlockingQueue<Client> clients;
    private final ConnectionListener listener;
    private MessageSender messageSender;
    
    public MainServer(String serverName, int port) {
        int maxClients = Integer.MAX_VALUE;
        this.clients = new LinkedBlockingQueue<>(maxClients);
        this.listener = new ConnectionListener(this, port);
    }
    
    public void addClient(Client client) {
        if(messageSender == null) {
            messageSender = new MessageSender(clients);
            new Thread(messageSender).start();
        }
        
        synchronized(clients) {
            clients.add(client);
            //messageSender.updateClients(clients);
        }
    }
    
    public void sendWelcomeMessage(Client client) {
        messageSender.sendWelcomeMessage(client);
        initMessageReceiver(client);
    }
    
    private void initMessageReceiver(Client client) {
        MessageReceiver messageReceiver = new MessageReceiver(this, client);
        new Thread(messageReceiver).start();
        System.out.println("server: client connected and message receiver started");
    }
}
