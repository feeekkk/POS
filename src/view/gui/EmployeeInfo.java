
package view.gui;

import controller.EmployeeController;
import java.awt.event.ActionEvent;

public class EmployeeInfo extends Parent {
    private final EmployeeController controller;

    public EmployeeInfo(Frame f) {
        super(f, true);
        
        controller = new EmployeeController(1);
        
        Thread t = new Thread(controller);
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
