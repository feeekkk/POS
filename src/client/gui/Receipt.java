package client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import mutualModels.Transaction;

public class Receipt extends Parent implements Runnable {
    private final Thread t;
    private long start, current, end = (long) (3 * Math.pow(10, 9));
    private Transaction transaction;
    private JTextArea paperReciept;
    
    
    public Receipt(Frame f, boolean top, Transaction transaction) {
        super(f, top);
        this.transaction = transaction;
        
        paperReciept = new JTextArea("Reciept \n \n" + "Employee: \n" + transaction.getEmployee().getFirst()
        + " " + transaction.getEmployee().getLast() + "\n \n \n" + transaction.getTotal());
        paperReciept.setBounds(this.getWidth()/2-125,this.getHeight()/2-200,250,400);
        paperReciept.setFont(new Font("Arial", Font.PLAIN, 24));
        paperReciept.setForeground(Color.CYAN);
        add(paperReciept);
        
        
        t = new Thread(this);
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        start = System.nanoTime();
        
        displayInfo();
        
        do {
            current = System.nanoTime() - start;
        } while(current <= end);
        
        System.out.println("receipt done");
        Dashboard dash = new Dashboard(frame);
        swap(this, dash);
    }
    
    private void displayInfo() {
        System.out.println("generating receipt");
    }
}