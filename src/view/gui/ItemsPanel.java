package view.gui;

import java.awt.event.ActionEvent;

public class ItemsPanel extends Parent {
    private Transaction t;

    public ItemsPanel(Frame f, Transaction t) {
        super(f);
        this.t = t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
