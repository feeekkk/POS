package view.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class TopBar extends Parent {
    Button dash, logout;

    public TopBar(Frame f) {
        super(f);
        //setBackground(Color.LIGHT_GRAY);
        setSize(1280, 100);
        setMinimumSize(new Dimension(1280, 720));
        setPreferredSize(new Dimension(1280, 720));
        
        dash = new Button(this, "Back", 10, 10, 100, 100);
        logout = new Button(this, "Logout", 1000, 10, 100, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == dash) {
            swap(new Dashboard(frame));
        }
        else if(obj == logout) {
            System.exit(0);
        }
    }
}