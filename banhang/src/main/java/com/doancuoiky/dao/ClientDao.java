/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doancuoiky.dao;
import com.doancuoiky.db.DBConnection;
import com.doancuoiky.model.ClientModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.List;
/**
 *
 * @author phuongmd
 */
public class ClientDao {
        public static boolean insertKhachHang(ClientModel client) {
        String sql = "INSERT INTO khachhang (tenkh, sodienthoai, email, diem, diachi) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, client.getHoTen());
            stmt.setString(2, client.getSDT());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getDiem());
            stmt.setString(5, client.getDiaChi());

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0; 

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
       
    public static boolean updateKhachHang(ClientModel client, String SDT) {
        String sql = "UPDATE khachhang SET tenkh = ?, sodienthoai = ?, email = ?, diem = ?, diachi = ?, sodienthoai= ? WHERE sodienthoai = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, client.getHoTen());
            stmt.setString(2, client.getSDT());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getDiem());
            stmt.setString(5, client.getDiaChi());
            stmt.setString(6, client.getSDT());
            stmt.setString(7, SDT);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0; 

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
           
    public static boolean updateKhachHangAfterPayment_usePoint(String SDT) {
        String sql = "UPDATE khachhang SET diem = 0 WHERE sodienthoai = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, SDT);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean updateKhachHangAfterPayment_plusPoint(long Point , String SDT) {
        String sql = "UPDATE khachhang SET diem = ? WHERE sodienthoai = ?";
        String PlusPoint = String.valueOf(Point);
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, PlusPoint);
            stmt.setString(2, SDT);
            
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0; 

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
            }
    }
    
    public static boolean deleteKhachHangBySDT(String sdt) {
        String sql = "DELETE FROM khachhang WHERE sodienthoai = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sdt);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0; 

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static Object[][] getAllKhachHang() {
        List<Object[]> rows = new ArrayList<>();
        String sql = "SELECT tenkh, sodienthoai, email, diem, diachi FROM khachhang";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Object[] row = new Object[] {
                    rs.getString("tenkh"),
                    rs.getString("sodienthoai"),
                    rs.getString("email"),
                    rs.getString("diem"),
                    rs.getString("diachi")
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
  
    public static Object[] getKhachHangBySoDienThoai(String sdt) {
    String sql = "SELECT tenkh, sodienthoai, diem FROM khachhang WHERE sodienthoai = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, sdt);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new Object[] {
                    rs.getString("tenkh"),
                    rs.getString("sodienthoai"),
                    rs.getString("diem"),
                };
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null; 
    }
}
