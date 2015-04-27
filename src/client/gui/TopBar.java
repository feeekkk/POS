package client.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopBar extends Parent {
    private Button dash, logout;
    private JLabel label;
    private JPanel host;
    
    public TopBar(Frame f, JPanel host) {
        super(f);
        this.host = host;
        init();
    }
    
    private void init() {
        Color background = new Color(100, 100, 100);
        setBackground(background);
        setSize(1280, 100);
        setMinimumSize(new Dimension(1280, 720));
        setPreferredSize(new Dimension(1280, 720));
        
        int width = 100, height = 50, y = 25;
        
        dash = new Button(this, "Back", 100, y, width, height);
        logout = new Button(this, "Logout", 1000, y, width, height);
        
        label = new JLabel("Logged in as: " + frame.getEmployee().getFirst() + " " + frame.getEmployee().getLast());
        label.setForeground(Color.WHITE);
        label.setBounds(500, y, 300, height);
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == dash) {
            swap(host, new Dashboard(frame));
        }
        else if(obj == logout) {
            this.frame.exit();
        }
    }
}