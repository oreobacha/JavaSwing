/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doancuoiky.model;

/**
 *
 * @author phuongmd
 */
public class VoucherModel {
    private final String MaKhuyenMai;
    private final String SoLuong;
    private final String TuNgay;
    private final String DenNgay;
    private final String GiamGia;
    public VoucherModel(String MaKhuyenMai, String SoLuong, String TuNgay, String DenNgay, String GiamGia) {
        this.MaKhuyenMai = MaKhuyenMai;
        this.SoLuong = SoLuong;
        this.TuNgay = TuNgay;
        this.DenNgay = DenNgay;
        this.GiamGia = GiamGia;
    }
    public String getMaKhuyenMai() { return MaKhuyenMai;}
    public String getSoLuong() { return SoLuong;}
    public String getTuNgay() { return TuNgay;}
    public String getDenNgay() { return DenNgay;}
    public String getGiamGia() { return GiamGia;}
}
