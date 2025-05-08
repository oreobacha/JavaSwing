/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.doancuoiky.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author ADMIN
 */
public class DBConnection {
    public static Connection getConnection() {
    try {
        String url = "jdbc:mysql://localhost:3306/qlbanhang?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
        String user = "root";      // hoặc tài khoản khác
        String password = "123456"; // mật khẩu MySQL

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        return null;
    }
    }
}
