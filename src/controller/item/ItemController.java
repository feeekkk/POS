package controller.item;

import controller.Controller;
import dao.ItemDAO;
import model.Item;
import view.View;

class ItemController extends Controller {
    protected final Item item;
    protected final ItemDAO dao;

    public ItemController(Item item) {
        this.item = item;
        this.dao = new ItemDAO();
    }

    @Override
    protected void displayView() {
        view.display();
    }
    
    protected void init(View view) {
        super.init(item, view);
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
