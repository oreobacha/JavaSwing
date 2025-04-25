package com.doancuoiky;
import com.doancuoiky.ui.LoginFrame;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
        LoginFrame Framelogin = new LoginFrame(); 
        Framelogin.setLocationRelativeTo(null); 
        Framelogin.setVisible(true);            
        });
    };
};