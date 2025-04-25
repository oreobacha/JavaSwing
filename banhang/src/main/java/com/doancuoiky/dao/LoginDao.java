/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.doancuoiky.dao;
import com.doancuoiky.db.DBConnection;
import com.doancuoiky.model.LoginModel;
import java.sql.*;
/**
 *
 * @author ADMIN
 */
public class LoginDao {
    public static LoginModel login(String username, String password) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                return new LoginModel(username, role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
