/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doancuoiky.model;

/**
 *
 * @author phuongmd
 */
public class ClientModel {
    private final String HoTen;
    private final String SDT;
    private final String Email;
    private final String Diem;
    private final String DiaChi;
    public ClientModel(String HoTen, String SDT, String Email, String Diem, String DiaChi) {
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.Email = Email;
        this.Diem = Diem;
        this.DiaChi = DiaChi;
    }
    public String getHoTen() { return HoTen;}
    public String getSDT() { return SDT;}
    public String getEmail() { return Email;}
    public String getDiem() { return Diem;}
    public String getDiaChi() { return DiaChi;}
}
