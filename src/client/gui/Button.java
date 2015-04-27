package client.gui;

import java.awt.Color;
import javax.swing.JButton;

public class Button extends JButton {
    public Button(Parent panel, String name, int x, int y, int width, int height) {
        final Color background = new Color(30, 139, 195);
        final Color hoverBackground = new Color(34, 167, 240);
        init(panel, name, x, y, width, height, background, hoverBackground);
    }
    
    public Button(Parent panel, String name, int x, int y, int width, int height, Color backgroundColor, Color hoverBackgroundColor) {
        init(panel, name, x, y, width, height, backgroundColor, hoverBackgroundColor);
    }
    
    private void init(Parent panel, String name, int x, int y, int width, int height, final Color backgroundColor, final Color hoverBackgroundColor) {
        setText(name);
        Color foreground = Color.WHITE;
        setForeground(foreground);
        setBackground(backgroundColor);
        this.setRolloverEnabled(true);
        setVisible(true);
        
        setBounds(x, y, width, height);
        
        addActionListener(panel);
        panel.add(this);
        
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(hoverBackgroundColor);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(backgroundColor);
            }
        });
    }
}