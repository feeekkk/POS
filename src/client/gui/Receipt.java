package client.gui;

import java.awt.event.ActionEvent;

public class Receipt extends Parent implements Runnable {
    private final Thread t;
    private long start, current, end = (long) (3 * Math.pow(10, 9));
    
    public Receipt(Frame f, boolean top) {
        super(f, top);
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