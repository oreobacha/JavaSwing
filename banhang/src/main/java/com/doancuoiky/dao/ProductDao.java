/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doancuoiky.dao;
import com.doancuoiky.db.DBConnection;
import com.doancuoiky.model.ProductModel;
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
public class ProductDao {
        public static Object[][] getAllProduct() {
            List<Object[]> rows = new ArrayList<>();
            String sql = "SELECT masp, imagesp, tensp, soluong, giaban, loaihang, barcode, trangthai FROM product";
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Object[] row = new Object[] {
                        rs.getString("masp"),
                        rs.getString("imagesp"),  
                        rs.getString("tensp"),
                        rs.getString("soluong"),
                        rs.getString("giaban"),
                        rs.getString("loaihang"),
                        rs.getString("barcode"),
                        rs.getString("trangthai")
                    };
                    rows.add(row);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Chuyển List<Object[]> thành Object[][]
            Object[][] data = new Object[rows.size()][];
            for (int i = 0; i < rows.size(); i++) {
                data[i] = rows.get(i);
            }
            return data;
            }
        
        public static Object[][] getAllProductBanHang() {
            List<Object[]> rows = new ArrayList<>();
            String sql = "SELECT masp, imagesp, tensp, soluong, giaban, barcode FROM product WHERE trangthai = 'Đang kinh doanh'";
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Object[] row = new Object[] {
                        rs.getString("masp"),
                        rs.getString("imagesp"),  
                        rs.getString("tensp"),
                        rs.getString("soluong"),
                        rs.getString("giaban"),
                        rs.getString("barcode"),
                    };
                    rows.add(row);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Chuyển List<Object[]> thành Object[][]
            Object[][] data = new Object[rows.size()][];
            for (int i = 0; i < rows.size(); i++) {
                data[i] = rows.get(i);
            }
            return data;
            }

       public static boolean createProduct(ProductModel product) {
        String sql = "INSERT INTO product (masp, tensp, soluong, giaban, loaihang, barcode, trangthai, imagesp) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getMasp());
            stmt.setString(2, product.getTenSp());
            stmt.setString(3, product.getSoLuong());
            stmt.setString(4, product.getGiaBan());
            stmt.setString(5, product.getLoaiHang());
            stmt.setString(6, product.getBarCode());
            stmt.setString(7, product.getTrangThai());
            stmt.setString(8, product.getimageSp());

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean updateProduct(ProductModel product, String maSp) {
        String sql = "UPDATE product SET tensp = ?, soluong = ?, giaban = ?, loaihang = ?, barcode = ?, trangthai = ?, imagesp = ?, masp = ? WHERE masp = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getTenSp());
            stmt.setString(2, product.getSoLuong());
            stmt.setString(3, product.getGiaBan());
            stmt.setString(4, product.getLoaiHang());
            stmt.setString(5, product.getBarCode());
            stmt.setString(6, product.getTrangThai());
            stmt.setString(7, product.getimageSp());
            stmt.setString(8, product.getMasp());
            stmt.setString(9, maSp);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
        public static boolean deleteProductByMaSp(String masp) {
            String sql = "DELETE FROM product WHERE masp = ?";

            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, masp);
                int affectedRows = stmt.executeUpdate();

                return affectedRows > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

}
