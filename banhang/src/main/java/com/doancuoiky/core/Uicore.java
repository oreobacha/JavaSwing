/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doancuoiky.core;

import javax.swing.JButton;

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
}
