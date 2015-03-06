
package view.gui;

import java.awt.event.ActionEvent;

public class Dashboard extends Parent {
    private final Button transaction, returnButton, inventory, employeeInfo;

    public Dashboard(Frame f) {
        super(f, true);
        int width = 300, height = 100, left = 100, right = 500, top = 100, bottom = 500;
        
        transaction = new Button(this, "Transaction", left, top, width, height );
        returnButton = new Button(this, "Return", right, top, width, height);
        inventory = new Button(this, "Inventory", left, bottom, width, height);
        employeeInfo = new Button(this, "Employee Info", right, bottom, width, height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == transaction) {
            swap(new Transaction(frame));
        }
        else if(obj == returnButton) {
            swap(new Return(frame));
        }
        else if(obj == inventory) {
            swap(new InventoryDashboard(frame));
        }
        else if(obj == employeeInfo) {
            swap(new EmployeeInfo(frame));
        }
    }
}