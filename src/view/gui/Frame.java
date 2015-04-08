package view.gui;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class Frame extends JFrame {
    
    private final ExecutorService service;
    private static int transactionID;
    
    public Frame() {
        super("Point Of Sales");
        
        int cpus = Runtime.getRuntime().availableProcessors();
        service = Executors.newFixedThreadPool(cpus);
        
        transactionID = 0;
        
        initGUI();
    }
    
    // submit task to be run
    public void execute(Runnable r) {
        service.execute(r);
        //log("runnable submitted");
    }
    
    private void initGUI() {
        setLayoutFeel("Nimbus");
        
        setLayout(null);
        
        setSize(1280, 720);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        Login login = new Login(this);
        
        add(login);

        validate();
        repaint();
    }
    
    private void setLayoutFeel(String s) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (s.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            // If Nimbus is not available, fall back to cross-platform
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            }
        }
    }
    
    public void exit() {
        // finish running any tasks that have been submitted and do not accept any new ones
        service.shutdown();
        
        log("exit request submitted");
        
        // wait 30 minutes at most for the system to terminate
        try {
            service.awaitTermination(30, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        log("peace");
        
        System.exit(0);
    }
    
    // get ID for a new transaction. Thread safe
    public static synchronized int requestTransactionID() {
        transactionID++;
        return transactionID;
    }
    
    private void log(String s) {
        System.out.println(s);
    }
}