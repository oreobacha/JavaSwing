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
    public static void setcolerbutton(JButton button, java.awt.Color normalColor) {
        Color pressedColor = normalColor.darker(); // màu khi nhấn (tối hơn)
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setFocusable(true); 
        button.setBorderPainted(false);
        button.setForeground(Color.white);
        button.setFocusPainted(false); 
        button.setContentAreaFilled(false);
        button.setOpaque(true);

        // Tùy vào trạng thái enable
        button.setBackground(button.isEnabled() ? normalColor : Color.LIGHT_GRAY);

        // Lắng nghe trạng thái nhấn giữ
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
    for (Component comp : container.getComponents()) {
        if (comp instanceof JTextField) {
            ((JTextField) comp).setBorder(BorderFactory.createLineBorder(Color.black));
        } else if (comp instanceof Container) {
            applyBlackBorderToAllTextFields((Container) comp); // đệ quy vào JPanel, JPanel con, ...
        }
    }
}
}
