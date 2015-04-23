
package server.model;

import java.io.ObjectOutputStream;

public class Request {
    private final Client client;
    private Object returnObject;
    private final Object received;
    
    public Request(Client client, Object receivedRequest) {
        this.client = client;
        this.received = receivedRequest;
    }
    
    public ObjectOutputStream getObjectOutputStream() {
        return client.getObjectOutputStream();
    }
    
    public Object getReceivedObject() {
        return received;
    }
    
    public void setReturnObject(Object o) {
        this.returnObject = o;
    }
    
    public Object getReturnObject() {
        return returnObject;
    }
}
