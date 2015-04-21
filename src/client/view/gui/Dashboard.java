package client.view.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class Dashboard extends Parent {
    private final Button transaction, returnButton, inventory, employeeInfo;

    public Dashboard(Frame f) {
        super(f, true);
        int width = 300, height = 200, left = 100, right = 800, top = 150, bottom = 400;
        
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