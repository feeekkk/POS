
package client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import mutualModels.*;

public class EmployeeInfo extends Parent {
    private Employee currentEmp;
    private JLabel empName;
    private JLabel empId;
    

    public EmployeeInfo(Frame f) {
        super(f, true);
        currentEmp = frame.getEmployee();
        
        empName = new JLabel("Employee Name: "+ currentEmp.getFirst()+" " +currentEmp.getLast());
        empName.setFont(new Font("Arial", Font.PLAIN, 24));
        empName.setForeground(Color.WHITE);
        empName.setBounds(100, 100, this.getWidth(), 50);
        add(empName);
        
        empId = new JLabel("Employee ID: "+ currentEmp.getId());
        empId.setFont(new Font("Arial", Font.PLAIN, 24));
        empId.setForeground(Color.WHITE);
        empId.setBounds(100, 150, this.getWidth(), 50);
        add(empId);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
