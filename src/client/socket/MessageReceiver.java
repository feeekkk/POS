
package client.socket;

import java.io.ObjectInputStream;

public class MessageReceiver {
    private static ObjectInputStream is;
    
    public MessageReceiver(ObjectInputStream objectInputStream) {
        MessageReceiver.is = objectInputStream;
    }
    
    public static ObjectInputStream getObjectInputStream() {
        return is;
    }

}
