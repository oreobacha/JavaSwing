/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doancuoiky.model;

import java.util.Date;

public class PaymentModel {
    private final String maThanhToan;
    private final long TongTienHang;
    private final long tongGiamGia;
    private final long tongDoanhThu;
    private final int soLuongSp;
    private final java.sql.Date ngayThanhToan;
    private final String sdt;
    private final String hoTen;


    public PaymentModel(String maThanhToan, long TongTienHang, long tongGiamGia, long tongDoanhThu, int soLuongSp, java.sql.Date ngayThanhToan, String sdt, String hoTen) {
        this.TongTienHang = TongTienHang;
        this.maThanhToan = maThanhToan;
        this.tongGiamGia = tongGiamGia;
        this.tongDoanhThu = tongDoanhThu;
        this.soLuongSp = soLuongSp;
        this.ngayThanhToan = ngayThanhToan;
        this.sdt = sdt;
        this.hoTen = hoTen; 
    }
    

    public String getMaThanhToan() { return maThanhToan; }
    public long getTongTienHang() { return TongTienHang; }
    public long getTongGiamGia() { return tongGiamGia; }
    public long getTongDoanhThu() { return tongDoanhThu; }
    public int getSoLuongSp() { return soLuongSp; }
    public java.sql.Date getNgayThanhToan() { return ngayThanhToan; }
    public String getSdt() { return sdt; }
    public String getHoTen() { return hoTen; }
}
