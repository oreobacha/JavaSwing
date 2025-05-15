/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doancuoiky.model;

import java.util.Date;

public class PaymentModel {
    private final String maThanhToan;
    private final double tongGiamGia;
    private final double tongDoanhThu;
    private final int soLuongSp;
    private final Date ngayThanhToan;
    private final String sdt;
    private final String hoTen;

    public PaymentModel(String maThanhToan, double tongGiamGia, double tongDoanhThu, int soLuongSp, Date ngayThanhToan, String sdt, String hoTen) {
        this.maThanhToan = maThanhToan;
        this.tongGiamGia = tongGiamGia;
        this.tongDoanhThu = tongDoanhThu;
        this.soLuongSp = soLuongSp;
        this.ngayThanhToan = ngayThanhToan;
        this.sdt = sdt;
        this.hoTen = hoTen;
    }

    public String getMaThanhToan() { return maThanhToan; }
    public double getTongGiamGia() { return tongGiamGia; }
    public double getTongDoanhThu() { return tongDoanhThu; }
    public int getSoLuongSp() { return soLuongSp; }
    public Date getNgayThanhToan() { return ngayThanhToan; }
    public String getSdt() { return sdt; }
    public String getHoTen() { return hoTen; }
}
