
package client.Workers;

import client.gui.PaymentTransaction;
import client.gui.Receipt;
import client.gui.TransactionHolder;
import client.socket.MessageSender;
import mutualModels.Purchase;

public class PaymentProcessor extends Worker{
    private final TransactionHolder panel;
    private final Purchase purchase;
    
    public PaymentProcessor(TransactionHolder holder, Purchase purchase) {
        this.panel = holder;
        this.purchase = purchase;
    }

    @Override
    protected Object doInBackground() throws Exception {
        System.out.println("client: sending purchase to server");
        MessageSender.getObjectOutputStream().writeObject(purchase);
        return null;
    }
    
    @Override
    protected void done() {
        System.out.println("client: sent purchase to server. swapping to receipt panel");
        panel.swap(panel, new Receipt(panel.getFrame(), true));
    }
}