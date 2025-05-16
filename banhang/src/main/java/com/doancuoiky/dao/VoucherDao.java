/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doancuoiky.dao;
import com.doancuoiky.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.List;
import com.doancuoiky.model.VoucherModel;
/**
 *
 * @author phuongmd
 */
public class VoucherDao {
    public static boolean insertVoucher(VoucherModel data) {
        String sql = "INSERT INTO voucher (MaKhuyenMai, SoLuong, TuNgay, DenNgay, GiamGia) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, data.getMaKhuyenMai().toUpperCase());
            stmt.setString(2, data.getSoLuong());
            stmt.setString(3, data.getTuNgay());
            stmt.setString(4, data.getDenNgay());
            stmt.setString(5, data.getGiamGia());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } 
    public static boolean updateVoucher(VoucherModel data, String MaKhuyenMai) {
        String sql = "UPDATE voucher SET SoLuong = ?, TuNgay = ?, DenNgay = ?, GiamGia = ?, MaKhuyenMai = ? WHERE MaKhuyenMai = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, data.getSoLuong());
            stmt.setString(2, data.getTuNgay());
            stmt.setString(3, data.getDenNgay());
            stmt.setString(4, data.getGiamGia());
            stmt.setString(5, data.getMaKhuyenMai().toUpperCase());
            stmt.setString(6, MaKhuyenMai.toUpperCase());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean deleteVoucher(String maKhuyenMai) {
        String sql = "DELETE FROM voucher WHERE MaKhuyenMai = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, maKhuyenMai);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Object[][] getAllVouchers() {
        List<Object[]> rows = new ArrayList<>();
        String sql = "SELECT MaKhuyenMai, SoLuong, TuNgay, DenNgay, GiamGia FROM voucher";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Object[] row = new Object[] {
                    rs.getString("MaKhuyenMai".toUpperCase()),
                    rs.getString("SoLuong"),
                    rs.getString("TuNgay"),
                    rs.getString("DenNgay"),
                    rs.getString("GiamGia")
                };
                rows.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Object[][] data = new Object[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            data[i] = rows.get(i);
        }

        return data;
    }

     public static Object[] getVoucherByMa(String maKhuyenMai) {
        String sql = "SELECT MaKhuyenMai, SoLuong, TuNgay, DenNgay, GiamGia FROM voucher WHERE MaKhuyenMai = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, maKhuyenMai.toUpperCase());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Object[] {
                        rs.getString("MaKhuyenMai"),
                        rs.getString("SoLuong"),
                        rs.getString("TuNgay"),
                        rs.getString("DenNgay"),
                        rs.getString("GiamGia")
                    };
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
     
    public static boolean updateVouchersAfterPayment(List<String> maKhuyenMaiList) {
       String sql = "UPDATE voucher SET SoLuong = SoLuong - 1 WHERE MaKhuyenMai = ? AND SoLuong > 0";

       try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

           for (String ma : maKhuyenMaiList) {
               stmt.setString(1, ma);
               stmt.addBatch();
           }

           stmt.executeBatch();
           return true;

       } catch (SQLException e) {
           e.printStackTrace();
           return false;
       }
   }
}
