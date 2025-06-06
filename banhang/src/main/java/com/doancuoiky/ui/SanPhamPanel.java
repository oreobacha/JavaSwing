/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.doancuoiky.ui;

import com.doancuoiky.core.FileUtils;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import com.doancuoiky.ui.TaoSpMoiFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.doancuoiky.ui.ChinhSuaSpFrame;
import java.awt.Color;
import java.text.NumberFormat;
import java.util.Locale;
import com.doancuoiky.dao.ProductDao;
import com.doancuoiky.core.FileUtils;
import com.doancuoiky.core.Uicore;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author phuongmd
 */
public class SanPhamPanel extends javax.swing.JPanel {
    private String username;

    public SanPhamPanel() {
        initComponents();
        setUptableView();
        setupEditSp();
        reloadtableView();
        Uicore.applyBlackBorderToAllTextFields(this);
        setupUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCreateProduct = new javax.swing.JButton();
        btnDetele = new javax.swing.JButton();
        btnreloadData = new javax.swing.JButton();
        btnexportExcel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tfSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1400, 900));

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 50));

        btnCreateProduct.setText("F1 - Tạo sản phẩm mới");
        btnCreateProduct.setPreferredSize(new java.awt.Dimension(170, 40));
        btnCreateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateProductActionPerformed(evt);
            }
        });

        btnDetele.setText("F2 - Xoá sản phẩm");
        btnDetele.setPreferredSize(new java.awt.Dimension(150, 40));
        btnDetele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeteleActionPerformed(evt);
            }
        });

        btnreloadData.setText("F5 - Làm mới");
        btnreloadData.setPreferredSize(new java.awt.Dimension(110, 40));
        btnreloadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreloadDataActionPerformed(evt);
            }
        });

        btnexportExcel.setText("F3 - Xuất excel");
        btnexportExcel.setPreferredSize(new java.awt.Dimension(110, 40));
        btnexportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexportExcelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 0));
        jLabel1.setText("Quản lý sản phẩm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnreloadData, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnexportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnDetele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCreateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCreateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDetele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnreloadData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnexportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setPreferredSize(new java.awt.Dimension(1400, 844));

        tfSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfSearch.setPreferredSize(new java.awt.Dimension(64, 25));

        jLabel3.setText("Nhập thông tin cần tìm");

        btnSearch.setText("Tìm kiếm");
        btnSearch.setPreferredSize(new java.awt.Dimension(83, 25));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1400, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jScrollPane1.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N

        jTable1.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Ảnh Sản Phẩm ", "Tên Sản Phẩm", "Số Lượng", "Giá Bán", "Loại Hàng", "BarCode", "Trạng Thái", "Người tạo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả sản phẩm", "Đang kinh doanh", "Ngừng kinh doanh" }));
        jComboBox1.setMinimumSize(new java.awt.Dimension(142, 25));
        jComboBox1.setPreferredSize(new java.awt.Dimension(142, 25));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel2.setText("Danh sách sản phẩm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                                .addGap(29, 29, 29)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateProductActionPerformed
        TaoSpMoiFrame CreateSpFrame = new TaoSpMoiFrame(this, username); 
        CreateSpFrame.setLocationRelativeTo(null);
        CreateSpFrame.setVisible(true);   
    }//GEN-LAST:event_btnCreateProductActionPerformed

    private void btnDeteleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeteleActionPerformed
        int row = jTable1.getSelectedRow();  // dòng được chọn
        int colCount = jTable1.getColumnCount();
        String maSp = jTable1.getValueAt(row, 0).toString();
        if (ProductDao.deleteProductByMaSp(maSp)) {
            JOptionPane.showMessageDialog(null, "Đã xóa mã sản phẩm: " + maSp + " thành công");
            reloadtableView();
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để xóa!");
        }
    }//GEN-LAST:event_btnDeteleActionPerformed

    private void btnreloadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreloadDataActionPerformed
        reloadtableView();
        JOptionPane.showMessageDialog(null, "Đã làm mới sản phẩm thành công");
    }//GEN-LAST:event_btnreloadDataActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        search_sp(tfSearch.getText());
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String selectedText = (String) jComboBox1.getSelectedItem();    
        if ("Tất cả sản phẩm".equals(selectedText)) {
            search_sp("");
        }
        else {
            search_sp(selectedText);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnexportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexportExcelActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        FileUtils.exportWithSaveDialog(jTable1, frame);
    }//GEN-LAST:event_btnexportExcelActionPerformed

    private void setupUI(){
       Uicore.setcolerbutton(btnDetele, new java.awt.Color(255,0,0));
       Uicore.setcolerbutton( btnCreateProduct, new java.awt.Color(0,102,102));
       Uicore.setcolerbutton(btnexportExcel, new java.awt.Color(0,102,102));
       Uicore.setcolerbutton(btnreloadData, new java.awt.Color(0,102,102));
       Uicore.setcolerbutton(btnSearch, new java.awt.Color(0,102,102));
       
    }
    
    private void reset_filter(){
        TableRowSorter<DefaultTableModel> rowSorter;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        rowSorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"));
    }
    
    private void search_sp (String str) {
        TableRowSorter<DefaultTableModel> rowSorter;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        rowSorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
    }
    
    public void reloadtableView(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        tfSearch.setText("");
        reset_filter();
        setUptableView();   
    }
    
    public void getUserModel(String username){
        this.username = username;
    }
    
    private void setUptableView(){
        jTable1.setRowHeight(80); 
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(false);
        jTable1.setGridColor(Color.LIGHT_GRAY);
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[][] data = ProductDao.getAllProduct();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (Object[] row : data) {
            model.addRow(row);
        }
        JTableHeader header = jTable1.getTableHeader();
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            TableColumn column = jTable1.getColumnModel().getColumn(i);
            column.setHeaderRenderer(centerRenderer);
        }
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            if (i != 1 && i!= 4) {
                jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }  
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new ImageCellRenderer());
        FileUtils.applyRedTextOnSelect(jTable1, new int[]{1}, new int[]{4});
    }
    
    private void setupEditSp(){
        jTable1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2 && jTable1.getSelectedRow() != -1) {
                int row = jTable1.getSelectedRow(); 
                int colCount = jTable1.getColumnCount();
                String maSp = jTable1.getValueAt(row, 0).toString();
                String imageSp = jTable1.getValueAt(row, 1).toString();
                String tenSp = jTable1.getValueAt(row, 2).toString();
                String SoLuong = jTable1.getValueAt(row, 3).toString();
                String GiaBan = jTable1.getValueAt(row, 4).toString();
                String LoaiHang = jTable1.getValueAt(row, 5).toString();
                String BarCode = jTable1.getValueAt(row, 6).toString();
                String TrangThai = jTable1.getValueAt(row, 7).toString();
                System.out.print(imageSp);
                // Mở trang chỉnh sửa sản phẩm
                ChinhSuaSpFrame EditSpFrame = new ChinhSuaSpFrame(SanPhamPanel.this, maSp, imageSp, tenSp, SoLuong, GiaBan, LoaiHang, BarCode, TrangThai, username); 
                EditSpFrame.setLocationRelativeTo(null);
                EditSpFrame.setVisible(true);    
            }
        }
    });
    }
 
    
    class ImageCellRenderer extends JLabel implements TableCellRenderer {
        public ImageCellRenderer() {
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);  
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            ImageIcon icon_base64 = FileUtils.convert_base64_to_image((String) value, 70, 70);
            setIcon(icon_base64);
            setText(null);
            return this;
        }
    }
    
  public class CurrencyCellRenderer extends DefaultTableCellRenderer {
    private final DecimalFormat formatter = new DecimalFormat("#,##0");

    public CurrencyCellRenderer() {
        setHorizontalAlignment(CENTER);
    }

    @Override
    protected void setValue(Object value) {
        if (value != null) {
            try {
                double price = Double.parseDouble(value.toString());
                setText(formatter.format(price) + " VND");
            } catch (NumberFormatException e) {
                setText(value.toString());
            }
        } else {
            setText("");
        }
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateProduct;
    private javax.swing.JButton btnDetele;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnexportExcel;
    private javax.swing.JButton btnreloadData;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
