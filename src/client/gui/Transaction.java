package client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class Transaction extends Parent{
    private final ItemsPanel items;
    private final PaymentPanel pp;
    
    public Transaction(Frame f) {
        super(f, true);
        items = new ItemsPanel(f, this);
        pp = new PaymentPanel(f, this);
        
        items.halfWidth();
        pp.halfWidth();
        
        items.setBackground(Color.red);
        pp.setBackground(Color.blue);
        
        setLayout(new BorderLayout());
        
        add(items, BorderLayout.WEST);
        add(pp, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }   
}