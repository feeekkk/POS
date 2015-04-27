
package client.gui;

import client.Workers.PaymentProcessor;
import java.awt.event.ActionEvent;
import mutualModels.Purchase;

public class PaymentTransaction extends Transaction {
    
    public PaymentTransaction(Frame f, TransactionHolder holder) {
        super(f, holder);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == pay) {
            Purchase purchase = new Purchase(holder.getItemsPanel().getItems(), frame.getEmployee(), holder.getItemsPanel().getTotalCost());
            // will handle gui update
            new PaymentProcessor(holder, purchase).execute();
        }
        super.actionPerformed(e);
    }
}