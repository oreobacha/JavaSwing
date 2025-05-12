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
/**
 *
 * @author phuongmd
 */
public class VoucherDao {
        public static Object[][] getAllVoucher() {
        List<Object[]> rows = new ArrayList<>();
        String sql = "SELECT mavoucher, giamgia FROM voucher";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Object[] row = new Object[] {
                    rs.getString("mavoucher"),
                    rs.getInt("giamgia")
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
    
}
