package client.gui;

import client.Workers.PaymentProcessor;
import java.awt.event.ActionEvent;
import javax.swing.*;
import mutualModels.Employee;
import mutualModels.Purchase;

public class PaymentPanel extends Parent {
    private final Button pay;
    private final Button credit;
    private final Button cash;
    private final Button debit;
    private JTextField cashAmt;
    private JTextField ccNum;
    private JTextField dcNum;
    private JTextField dcPin;
    private Transaction t;

    public PaymentPanel(Frame f, Transaction t) {
        super(f);
        this.t = t;
        credit = new Button (this, "CC",50, 100, 50, 50);
        cash = new Button (this, "$$", 100, 100, 50, 50);
        debit = new Button (this, "DC", 150, 100, 50, 50);
        pay = new Button(this, "Pay", 500, 500, 100, 50);
        
        ccNum = new JTextField("credit card number");
        ccNum.setBounds(50, 200, 300, 50);
        cashAmt = new JTextField("cash amount");
        cashAmt.setBounds(50, 200, 300, 50);
        dcNum = new JTextField("debit card number");
        dcNum.setBounds(50, 200, 300, 50);
        dcPin = new JTextField("pin");
        dcPin.setBounds(50, 250, 100, 50);
        
        
        
        
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
        else if(obj == credit){
            
            //ccNum.setBounds(100, 200, 300, 50);
            remove(cashAmt);
            remove(dcNum);
            remove(dcPin);
            add(ccNum);
            revalidate();
            repaint();
        }
        else if(obj == cash){
            remove(ccNum);
            remove(dcNum);
            remove(dcPin);
            add(cashAmt);
            this.revalidate();
            this.repaint();
        }
        else if(obj == debit){
            remove(ccNum);
            remove(cashAmt);
            add(dcNum);
            add(dcPin);
            revalidate();
            repaint();
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