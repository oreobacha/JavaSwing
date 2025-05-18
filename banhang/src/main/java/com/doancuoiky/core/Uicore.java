/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doancuoiky.core;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/**
 *
 * @author phuongmd
 */
public class Uicore {
    public static void setcolerbutton(JButton button, java.awt.Color normalColor) {
        Color pressedColor = normalColor.darker(); 
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setFocusable(true); 
        button.setBorderPainted(false);
        button.setForeground(Color.white);
        button.setFocusPainted(false); 
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setFont(button.getFont().deriveFont(Font.BOLD));

        button.setBackground(button.isEnabled() ? normalColor : Color.LIGHT_GRAY);

        button.getModel().addChangeListener(e -> {
            if (!button.isEnabled()) {
                button.setBackground(Color.LIGHT_GRAY);
            } else if (button.getModel().isPressed()) {
                button.setBackground(pressedColor);
            } else {
                button.setBackground(normalColor);
            }
        });
    }
    
    public static void applyBlackBorderToAllTextFields(Container container) {
        //hàm đệ quy chạy toàn bộ jtextfield khi call trong view
        for (Component comp : container.getComponents()) {
            if (comp instanceof JTextField) {
                JTextField textField = (JTextField) comp;
                Border outerBorder = BorderFactory.createLineBorder(Color.black);
                Border innerPadding = BorderFactory.createEmptyBorder(0, 10, 0, 10);
                Border compound = BorderFactory.createCompoundBorder(outerBorder, innerPadding);
                textField.setBorder(compound);
            } else if (comp instanceof Container) {
                applyBlackBorderToAllTextFields((Container) comp); 
            }
        }
    }

}

