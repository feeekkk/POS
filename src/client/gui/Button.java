package client.gui;

import java.awt.Color;
import javax.swing.JButton;

public class Button extends JButton {
    public Button(Parent panel, String name, int x, int y, int width, int height) {
        setText(name);
        //setForeground(Color.WHITE);
        //setBackground(Color.BLUE);
        setVisible(true);
        
        setBounds(x, y, width, height);
        
        addActionListener(panel);
        panel.add(this);
    }

}