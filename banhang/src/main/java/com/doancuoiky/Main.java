package com.doancuoiky;
import com.doancuoiky.ui.LoginFrame;
import com.doancuoiky.ui.AdminFrame;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
//        LoginFrame Framelogin = new LoginFrame(); 
        LoginFrame Framelogin = new LoginFrame(); 
        Framelogin.setLocationRelativeTo(null); 
        Framelogin.setVisible(true);            
        });
    };
};