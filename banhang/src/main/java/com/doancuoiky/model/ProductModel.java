/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doancuoiky.model;

/**
 *
 * @author phuongmd
 */
public class ProductModel {
    private final String Masp;
    private final String TenSp;
    private final String SoLuong;
    private final String GiaBan;
    private final String LoaiHang;
    private final String BarCode;
    private final String TrangThai;
    private final String Nguoitao;
    private final String imageSp;
    public ProductModel(String Masp, String TenSp, String SoLuong, String GiaBan, String LoaiHang, String BarCode, String TrangThai, String Nguoitao,String imageSp) {
        this.Masp = Masp;
        this.TenSp = TenSp;
        this.SoLuong = SoLuong;
        this.GiaBan = GiaBan;
        this.LoaiHang = LoaiHang;
        this.BarCode = BarCode;
        this.TrangThai = TrangThai;
        this.Nguoitao = Nguoitao;
        this.imageSp = imageSp;
    }
    public String getMasp() { return Masp;}
    public String getTenSp() { return TenSp;}
    public String getSoLuong() { return SoLuong;}
    public String getGiaBan() { return GiaBan;}
    public String getLoaiHang() { return LoaiHang;}
    public String getBarCode() { return BarCode;}
    public String getTrangThai() { return TrangThai;}
    public String getNguoitao() { return Nguoitao;}
    public String getimageSp() { return imageSp;}
}
