package client.gui;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import mutualModels.Employee;

public class Frame extends JFrame implements Runnable {

    private Employee employee;
    
    public Frame() {
        super("Point Of Sales");
    }
    
    public void run() {
        initGUI();
    }
    
    public Employee getEmployee() {
        return employee;
    }
    
    public void setEmployee(Employee e) {
        this.employee = e;
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
        System.out.println("peace");
        System.exit(0);
    }
}