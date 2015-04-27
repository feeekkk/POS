package client.gui;

import client.Workers.EmployeeLookup;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import mutualModels.Employee;

public class Login extends Parent {
    private Button go;
    private JTextField id, password;
    
    public Login(Frame f) {
        
        super(f);
        
        id = new JTextField("ID Number");
        id.setBounds(250, 100, 200, 45);
        add(id);
        
        password = new JTextField("Password");
        password.setBounds(250, 150, 200, 45);
        add(password);
        
        go = new Button(this, "Login", 475, 100, 100, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == go) {
            int idIn = Integer.parseInt(id.getText());
            String passwordIn = password.getText();
            EmployeeLookup employeeLookup = new EmployeeLookup(this, idIn, passwordIn);
            employeeLookup.execute();
            System.out.println("client: submitting employee lookup");
            // employee lookup complete will handle gui update
            
            //frame.setEmployee(new Employee(0, "login temp", "employee", "frame password"));
            //swap(new Dashboard(frame));
        }
    }
}