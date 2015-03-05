package view.gui;

import java.awt.event.ActionEvent;

public class Login extends Parent {
    private Button go;
    
    public Login(Frame f) {
        super(f);
        
        go = new Button("Go");
        add(go);
        go.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == go) {
            swap(new Dashboard(frame));
        }
    }
}