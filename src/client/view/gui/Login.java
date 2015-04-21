package client.view.gui;

import java.awt.event.ActionEvent;

public class Login extends Parent {
    private Button go;
    
    public Login(Frame f) {
        super(f);
        
        go = new Button(this, "Login", 100, 100, 100, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == go) {
            swap(new Dashboard(frame));
        }
    }
}