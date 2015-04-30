/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.Workers;

import client.gui.Dashboard;
import client.gui.Frame;
import client.gui.Login;
import client.socket.MessageReceiver;
import client.socket.MessageSender;
import java.io.ObjectInputStream;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleRole;
import mutualModels.Employee;

public class EmployeeLookup extends Worker {
    private Employee employee;
    private Login panel;
    
    public EmployeeLookup(Login panel, int id, String password) {
        System.out.println("Employee ID: "+id);
        this.employee = new Employee(id, null, null, password);
        this.panel = panel;
    }

    @Override
    protected Employee doInBackground() throws Exception {
        MessageSender.getObjectOutputStream().writeObject(employee);
        ObjectInputStream is = MessageReceiver.getObjectInputStream();
        System.out.println("client: waiting for server employee lookup response");
        this.employee = (Employee) is.readObject();
        System.out.println("EMPLOYEE: "+employee);
        return employee;
    }
    
   
    @Override
    protected void done(){
        System.out.println("client: employee lookup response received");
        Frame frame = panel.getFrame();
        
        try {
            this.employee = (Employee) get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(EmployeeLookup.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("client: setting employee and swapping to dashboard");
        frame.setEmployee(employee);
        panel.swap(panel, new Dashboard(frame));
    }
}
