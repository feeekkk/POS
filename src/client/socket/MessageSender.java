

package client.socket;

import java.io.ObjectOutputStream;

public class MessageSender {
    private static ObjectOutputStream os;
    
    public MessageSender(ObjectOutputStream outputStream) {
        MessageSender.os = outputStream;
    }
    
    public static ObjectOutputStream getObjectOutputStream() {
        return os;
    }

}
