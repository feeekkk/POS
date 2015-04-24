
package client.Workers;

import client.gui.PaymentPanel;
import client.gui.Receipt;
import client.socket.MessageSender;
import mutualModels.Purchase;

public class PaymentProcessor extends Worker{
    private final PaymentPanel panel;
    private final Purchase purchase;
    
    public PaymentProcessor(PaymentPanel panel, Purchase purchase) {
        this.panel = panel;
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
        panel.swap(panel.getTransaction(), new Receipt(panel.getFrame(), true));
    }
}