package controller.transaction;

import model.Return;
import view.View;

public class ReturnController extends TransactionController{
    private final Return r;
    
    public ReturnController(Return r) {
        super(r);
        this.r = r;
    }
    
    @Override
    protected void init(View view) {
        init(r, view);
    }
    
    @Override
    public void run() {
        
    }
}