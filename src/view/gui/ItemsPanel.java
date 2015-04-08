package view.gui;

import controller.item.ItemLookup;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.Timer;

public class ItemsPanel extends Parent {
    private final Transaction t;
    private final Button b;
    private final ArrayList<ItemLookup> incomplete;
    
    private int itemX, itemY, itemWidth, itemHeight;
    
    private final Timer timer;

    public ItemsPanel(Frame f, Transaction t) {
        super(f);
        this.t = t;
        
        itemX = 10;
        itemY = 200;
        itemWidth = 200;
        itemHeight = 20;
        
        incomplete = new ArrayList<>();
        // create a timer that checks to see if an item has been found
        timer = new Timer(10, this);
        
        b = new Button(this, "click to generate an item", 100, 100, 300, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == b) {
            // yo lets look up the item based on the ID
            int id = 1;
            ItemLookup lookup = new ItemLookup(1);
            frame.execute(lookup);
            incomplete.add(lookup);

            // start the timer now that there is an incomplete
            if(!timer.isRunning()) {
                timer.start();
                System.out.println("timer started");
            }
            
        }
        
        // cycle through and see if any lookups are now complete
        else if(obj == timer) {
            for(int i = 0; i < incomplete.size(); i++) {
                if(incomplete.get(i).isComplete()) {
                    add(incomplete.get(i).getLabel());
                    incomplete.remove(i);
                }
            }
            
            // stop the timer if there arent any incompletes left to save resources
            if(incomplete.isEmpty()) {
                timer.stop();
                System.out.println("timer stopped");
            }
        }
    }
    
    public void add(JLabel label) {
        label.setBounds(itemX, itemY, itemWidth, itemHeight);
        itemY += itemHeight + 10;
        super.add(label);
        revalidate();
        repaint();
    }

}
