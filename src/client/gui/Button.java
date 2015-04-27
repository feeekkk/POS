package client.gui;

import java.awt.Color;
import javax.swing.JButton;

public class Button extends JButton {
    public Button(Parent panel, String name, int x, int y, int width, int height) {
        setText(name);
        Color foreground = Color.WHITE;
        final Color background = new Color(30, 139, 195);
        final Color hoverBackground = new Color(34, 167, 240);
        setForeground(foreground);
        setBackground(background);
        this.setRolloverEnabled(true);
        setVisible(true);
        
        setBounds(x, y, width, height);
        
        addActionListener(panel);
        panel.add(this);
        
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(hoverBackground);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(background);
            }
        });
    }

}