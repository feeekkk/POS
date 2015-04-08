package controller.transaction;

import model.Purchase;
import view.TempView;
import view.View;

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