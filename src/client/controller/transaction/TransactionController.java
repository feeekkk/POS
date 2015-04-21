/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.controller.transaction;

import client.controller.Controller;
import client.model.Transaction;
import client.view.View;
import client.view.gui.Frame;

class TransactionController extends Controller {
    protected final Transaction transaction;
    protected int id;

    public TransactionController(Transaction transaction) {
        this.transaction = transaction;
        this.id = Frame.requestTransactionID();
    }

    @Override
    protected void displayView() {
        view.print();
    }
    
    protected void init(View view) {
        init(transaction, view);
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
