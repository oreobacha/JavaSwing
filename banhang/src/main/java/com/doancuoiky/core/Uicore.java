/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doancuoiky.core;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author phuongmd
 */
public class Uicore {
    public static void setcolerbutton(JButton button, java.awt.Color color) {
        button.setFocusable(true); 
        button.setFocusPainted(false); 
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(color);
    }
    
    public static void applyBlackBorderToAllTextFields(Container container) {
    for (Component comp : container.getComponents()) {
        if (comp instanceof JTextField) {
            ((JTextField) comp).setBorder(BorderFactory.createLineBorder(Color.darkGray));
        } else if (comp instanceof Container) {
            applyBlackBorderToAllTextFields((Container) comp); // đệ quy vào JPanel, JPanel con, ...
        }
    }
}
}
