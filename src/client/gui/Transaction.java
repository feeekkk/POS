package client.gui;

import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public abstract class Transaction extends Parent{
    protected TransactionHolder holder;
    protected final Button pay;
    protected final Button credit;
    protected final Button cash;
    protected final Button debit;
    protected JTextField cashAmt;
    protected JTextField ccNum;
    protected JTextField dcNum;
    protected JTextField dcPin;
    
    public Transaction(Frame f, TransactionHolder holder) {
        super(f, false);
        
        this.holder = holder;
        
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
        
        pay.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == credit){
            //ccNum.setBounds(100, 200, 300, 50);
            remove(cashAmt);
            remove(dcNum);
            remove(dcPin);
            add(ccNum);
            
        }
        else if(obj == cash){
            remove(ccNum);
            remove(dcNum);
            remove(dcPin);
            add(cashAmt);
        }
        else if(obj == debit){
            remove(ccNum);
            remove(cashAmt);
            add(dcNum);
            add(dcPin);
        }
        holder.revalidate();
        holder.repaint();
    }   
    
    public void setPaymentButtonEnabled(boolean b) {
        pay.setEnabled(b);
    }
}