package client.gui;

import client.Workers.EmployeeLookup;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import mutualModels.Employee;

public class Login extends Parent {
    private Button go;
    private JTextField id, password;
    public static int userid;
    public static String userpassword;
    
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
            userid = Integer.parseInt(id.getText());
            userpassword = password.getText();
            EmployeeLookup employeeLookup = new EmployeeLookup(this, userid, userpassword, 0);
            System.out.println("client: Employee ID: "+userid);
            System.out.println("client: Employee Password: "+userpassword);
            employeeLookup.execute();
            System.out.println("client: submitting employee lookup");
            // employee lookup complete will handle gui update
            
            //frame.setEmployee(new Employee(0, "login temp", "employee", "frame password"));
            //swap(new Dashboard(frame));
        }
    }
}