package view.item;

import javax.swing.JLabel;
import view.View;

public class ItemView extends View {
    private String name, text;
    private Double price;
    
    public ItemView(String name, double price) {
        update(name, price);
    }

    public void update(String name, double price) {
        this.name = name;
        this.price = price;
        
        this.text = "Item: " + name + " | Price: " + price;
    }

    public JLabel getLabel() {
        JLabel label = new JLabel(text);
        return label;
    }

    @Override
    public void print() {
        System.out.println(text);
    }

}
