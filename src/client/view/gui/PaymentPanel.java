package client.view.gui;

import java.awt.event.ActionEvent;

public class PaymentPanel extends Parent {
    private Button pay;
    private Transaction t;

    public PaymentPanel(Frame f, Transaction t) {
        super(f);
        this.t = t;
        
        pay = new Button(this, "Pay", 200, 200, 200, 200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == pay) {
            swap(t, new Receipt(frame, true));
        }
    }
}