package view.gui;

import java.awt.Color;
import javax.swing.JButton;

public class Button extends JButton {
    public Button(String name) {
        setText(name);
        setBackground(Color.BLUE);
        setVisible(true);
    }
}