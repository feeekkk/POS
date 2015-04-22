package client.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionStarter {
    private Socket socket;
    private MessageReceiver receiver;
    private MessageSender sender;
    
    public ConnectionStarter(String serverName, int port) {
        try {
            System.out.println("client: Connecting to server " + serverName +  " on port: " + port);
            this.socket = new Socket(serverName, port);
            System.out.println("client: Just connected to " + socket.getRemoteSocketAddress());
        } catch (IOException ex) {
            Logger.getLogger(ConnectionStarter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initStreams();
    }
    
    private void initStreams() {
        InputStream inputStream;
        OutputStream outputStream;
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        
        System.out.println("client: getting streams... will see success when complete");
        try {
            inputStream = socket.getInputStream();
            System.out.println("client: got input");
            outputStream = socket.getOutputStream();
            System.out.println("client: got output");
            objectInputStream = new ObjectInputStream(inputStream);
            System.out.println("client: got object in");
            objectOutputStream = new ObjectOutputStream(outputStream);
            System.out.println("client: got object out");
        } catch (IOException ex) {
            Logger.getLogger(ConnectionStarter.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("client: finished getting streams");
        
        this.receiver = new MessageReceiver(objectInputStream);
        this.sender = new MessageSender(objectOutputStream);
    }
}
