package client.controller.item;


import client.controller.Controller;
import server.dao.ItemDAO;
import javax.swing.JLabel;
import client.model.Item;
import client.view.item.ItemView;

class ItemController extends Controller {
    protected Item item;
    protected ItemView itemView;
    protected final ItemDAO dao;

    public ItemController(Item item) {
        this.item = item;
        this.dao = new ItemDAO();
    }
    
    // only use this constructor when doing an item lookup since we dont have a model yet
    public ItemController() {
        this.dao = new ItemDAO();
    }

    @Override
    public void displayView() {
        view.print();
    }
    
    public JLabel getLabel() {
        return itemView.getLabel();
    }
    
    protected void init(ItemView view) {
        super.init(item, view);
        this.itemView = view;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
