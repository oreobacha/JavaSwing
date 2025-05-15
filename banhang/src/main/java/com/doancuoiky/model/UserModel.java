/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doancuoiky.model;

/**
 *
 * @author ADMIN
 */
public class UserModel {
    private final String username;
    private final String password;
    private final String role;
    private final String hoTen;
    private final String SDT;
    private final String DiaChi;

    public UserModel(String hoTen, String SDT, String DiaChi, String username, String password, String role) {
        this.hoTen = hoTen;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.username = username;
        this.password = password;
        this.role = role;
                                        
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public String getHoTen() { return hoTen; }
    public String getSDT() { return SDT; }
    public String getDiaChi() { return DiaChi; }
}
