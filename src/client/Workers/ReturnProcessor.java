

package client.Workers;

import client.gui.Receipt;
import client.gui.TransactionHolder;
import client.socket.MessageSender;
import mutualModels.Return;

public class ReturnProcessor extends Worker {
    private final TransactionHolder holder;
    private final Return return1;

    public ReturnProcessor(TransactionHolder holder, Return return1) {
        this.holder = holder;
        this.return1 = return1;
    }
    
    @Override
    protected Object doInBackground() throws Exception {
        System.out.println("client: sending return to server");
        MessageSender.getObjectOutputStream().writeObject(return1);
        return null;
    }
    
    @Override
    protected void done() {
        System.out.println("client: sent return to server. swapping to receipt panel");
        holder.swap(holder, new Receipt(holder.getFrame(), true));
    }

}
