package client.controller.transaction;

import client.model.Purchase;
import client.view.TempView;
import client.view.View;

public class PurchaseController extends TransactionController {
    private final Purchase purchase;

    public PurchaseController(Purchase purchase) {
        super(purchase);
        this.purchase = purchase;
        
        init(new TempView());
    }
    
    @Override
    protected void init(View view) {
        init(purchase, view);
    }
    
    @Override
    public void run() {
        
    }
}