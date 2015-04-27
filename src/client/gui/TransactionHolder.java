

package client.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class TransactionHolder extends Parent {
    private ItemsPanel items;
    private final Transaction transaction;
    
    public TransactionHolder(Frame f, boolean paymentTransaction) {
        super(f, true);
        if(paymentTransaction) {
            transaction = new PaymentTransaction(f, this);
        }
        else {
            transaction = new ReturnTransaction(f, this);
        }
        
        init();
    }
    
    public void init() {
        items = new ItemsPanel(this);
        items.halfWidth();
        transaction.halfWidth();
        setLayout(new BorderLayout());
        add(transaction, BorderLayout.EAST);
        add(items, BorderLayout.WEST);
    }
    public ItemsPanel getItemsPanel() {
        return items;
    }
    
    public void setPaymentButtonEnabled(boolean b) {
        transaction.setPaymentButtonEnabled(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
