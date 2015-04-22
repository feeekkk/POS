
package server.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private InputStream inputStream;
    
    public Client(Socket socket) {
        try {
            this.inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            this.objectOutputStream = new ObjectOutputStream(outputStream);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initObjectInputStream() {
        try {
            this.objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }
    
    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

}