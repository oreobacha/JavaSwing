/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doancuoiky.dao;

import com.doancuoiky.db.DBConnection;
import com.doancuoiky.model.PaymentModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDao {

    public static boolean createPayment(PaymentModel payment) {
        String sql = "INSERT INTO payment (mathanhtoan, tonggiamgia, tongdoanhthu, soluongsp, ngaythanhtoan, sdt, hoten) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, payment.getMaThanhToan());
            stmt.setDouble(2, payment.getTongGiamGia());
            stmt.setDouble(3, payment.getTongDoanhThu());
            stmt.setInt(4, payment.getSoLuongSp());
            stmt.setDate(5, new java.sql.Date(payment.getNgayThanhToan().getTime()));
            stmt.setString(6, payment.getSdt());
            stmt.setString(7, payment.getHoTen());

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

public static Object[][] getPaymentByDateRange(Date from, Date to) {
    List<Object[]> rows = new ArrayList<>();
    String sql = "SELECT ngaythanhtoan, SUM(tonggiamgia) AS tonggiamgia, SUM(tongdoanhthu) AS tongdoanhthu, SUM(soluongsp) AS soluongsp " +
                 "FROM payment WHERE ngaythanhtoan BETWEEN ? AND ? GROUP BY ngaythanhtoan ORDER BY ngaythanhtoan ASC";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setDate(1, new java.sql.Date(from.getTime()));
        stmt.setDate(2, new java.sql.Date(to.getTime()));

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Object[] row = new Object[] {
                    rs.getDate("ngaythanhtoan"),
                    rs.getDouble("tonggiamgia"),
                    rs.getDouble("tongdoanhthu"),
                    rs.getInt("soluongsp"),
                };
                rows.add(row);
            }
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
}
