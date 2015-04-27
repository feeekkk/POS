package client.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public abstract class Parent extends JPanel implements ActionListener {
    protected final Frame frame;
    protected TopBar topBar;
    private int width = 1280, height = 720;
    
    public Parent(Frame f) {
        this.frame = f;
        init();
    }
    
    public Parent(Frame f, boolean top) {
        this.frame = f;
        if(top) {
            topBar = new TopBar(f, this);
            add(topBar);
        }
        init();
    }
    
    private void init() {
        Color background = new Color(50, 50, 50);
        setBackground(background);
        setLayout(null);
        resize();
        setVisible(true);
        validate();
    }
    
    private void resize() {
        setSize(width, height);
        setMinimumSize(new Dimension(width, height));
        setPreferredSize(new Dimension(width, height));
    }
    
    protected void swap(JPanel p) {
        frame.remove(this);
        frame.add(p);
        frame.revalidate();
        frame.repaint();
    }
    
    public void swap(JPanel p1, JPanel p2) {
        frame.remove(p1);
        frame.add(p2);
        frame.revalidate();
        frame.repaint();
    }
    
    protected void halfWidth() {
        width /= 2;
        resize();
    }
    public int getWidth(){
        return width;
    }
}