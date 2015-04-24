package client.gui;

import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import mutualModels.Employee;

public class Login extends Parent {
    private Button go;
    private JTextField username, password;
    
    public Login(Frame f) {
        
        super(f);
        
        username = new JTextField("Username");
        username.setBounds(250, 100, 200, 45);
        add(username);
        
        
        password = new JTextField("Password");
        password.setBounds(250, 150, 200, 45);
        add(password);
        
        go = new Button(this, "Login", 475, 100, 100, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == go) {
            frame.setEmployee(new Employee(0, "frame first", "frame last", "frame password"));
            swap(new Dashboard(frame));
        }
    }
}