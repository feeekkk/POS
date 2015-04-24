package client.gui;

import client.Workers.PaymentProcessor;
import java.awt.event.ActionEvent;
import mutualModels.Employee;
import mutualModels.Purchase;

public class PaymentPanel extends Parent {
    private final Button pay;
    private final Transaction t;

    public PaymentPanel(Frame f, Transaction t) {
        super(f);
        this.t = t;
        
        pay = new Button(this, "Pay", 200, 200, 200, 200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == pay) {
            // temp. actually need to implement purchases. should have all items, employee, etc.
            Purchase purchase = new Purchase(t.getItemsPanel().getItems(), new Employee(0, "first", "last", "password"), 69.69);
            // will handle gui update
            new PaymentProcessor(this, purchase).execute();
        }
    }
    
    public Transaction getTransaction() {
        return t;
    }
    
    public Frame getFrame() {
        return frame;
    }
    
    public void setPayment(boolean b) {
        pay.setEnabled(b);
    }
}