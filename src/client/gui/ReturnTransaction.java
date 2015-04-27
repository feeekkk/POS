/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.gui;

import client.Workers.ReturnProcessor;
import java.awt.event.ActionEvent;
import mutualModels.Return;

public class ReturnTransaction extends Transaction {
    
    public ReturnTransaction(Frame f, TransactionHolder holder) {
        super(f, holder);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == pay) {
            Return return1 = new Return(holder.getItemsPanel().getItems(), frame.getEmployee(), holder.getItemsPanel().getTotalCost());
            // will handle gui update
            new ReturnProcessor(holder, return1).execute();
        }
    }

}
