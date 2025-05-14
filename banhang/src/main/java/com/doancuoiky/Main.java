package com.doancuoiky;
import com.doancuoiky.ui.LoginFrame;
import com.doancuoiky.ui.MainFrame;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
//        LoginFrame Framelogin = new LoginFrame(); 
        MainFrame Framelogin = new MainFrame("admin"); 
        Framelogin.setLocationRelativeTo(null); 
        Framelogin.setVisible(true);            
        });
    };
};