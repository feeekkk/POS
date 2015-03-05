package view.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public abstract class Parent extends JPanel implements ActionListener {
    protected final Frame frame;
    
    public Parent(Frame f) {
        this.frame = f;
        
        setSize(1280, 720);
        setMinimumSize(new Dimension(1280, 720));
        setPreferredSize(new Dimension(1280, 720));
        setBackground(Color.DARK_GRAY);
        setVisible(true);
    }
    
    protected void swap(JPanel p) {
        frame.remove(this);
        frame.add(p);
        
        frame.revalidate();
        frame.repaint();
    } 
}