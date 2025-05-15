package com.doancuoiky.dao;

import com.doancuoiky.db.DBConnection;
import com.doancuoiky.model.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static boolean insertUser(UserModel user) {
        String sql = "INSERT INTO users (username, password, role, hoTen, SDT, DiaChi) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.setString(4, user.getHoTen());
            stmt.setString(5, user.getSDT());
            stmt.setString(6, user.getDiaChi());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateUser(UserModel user, String username) {
        String sql = "UPDATE users SET password = ?, role = ?, hoTen = ?, SDT = ?, DiaChi = ?, username = ? WHERE username = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getRole());
            stmt.setString(3, user.getHoTen());
            stmt.setString(4, user.getSDT());
            stmt.setString(5, user.getDiaChi());
            stmt.setString(6, user.getUsername());
            stmt.setString(7, username);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteUser(String username) {
        String sql = "DELETE FROM users WHERE username = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Object[][] getAllUsers() {
        List<Object[]> rows = new ArrayList<>();
        String sql = "SELECT hoTen, SDT, DiaChi, username, password, role FROM users";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("hoTen"),
                    rs.getString("SDT"),
                    rs.getString("DiaChi"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role")
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

    public static Object[] loginByUsernamePassword(String username, String password) {
   String sql = "SELECT hoTen, SDT, DiaChi, username, password, role FROM users WHERE username = ? and password = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, username);
        stmt.setString(2, password);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new Object[] {
                    rs.getString("hoTen"),
                    rs.getString("SDT"),
                    rs.getString("DiaChi"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role")
                };
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null; // không tìm thấy user
    }
    
    public static Object[] getUserByUsername(String username) {
    String sql = "SELECT hoTen, SDT, DiaChi, username, password, role FROM users WHERE username = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, username);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new Object[] {
                    rs.getString("hoTen"),
                    rs.getString("SDT"),
                    rs.getString("DiaChi"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role")
                };
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null; // không tìm thấy user
    }
}
