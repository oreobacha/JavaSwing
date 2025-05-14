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
import com.doancuoiky.dao.VoucherDao;
import com.doancuoiky.dao.ClientDao;
import com.doancuoiky.core.FileUtils;
import com.doancuoiky.core.Uicore;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.DecimalFormat;
import java.util.EventObject;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;


/**
 *
 * @author phuongmd
 */
public class BanHangPanel extends javax.swing.JPanel {
    private String Point = "0"; 
    private String PointGetClient = "0"; 
    private String MaHoaDon; 
    public Boolean isMaHoaDon = false; 

    public BanHangPanel() {
        initComponents();
        setupUI();
        setUptableView();
        setUptableViewTinhTien();
        setUptableViewVoucher();
        setupAddSp();
        remove_focus_table();
        setupMoneyField();
        setupbidingButton();
        Uicore.applyBlackBorderToAllTextFields(this);
//        Uicore.applyAutoFixToTextFields(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelProduct = new javax.swing.JPanel();
        tfSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableSpDangBan = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableTinhTien = new javax.swing.JTable();
        pannelPayment = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfInputMaKH = new javax.swing.JTextField();
        btnsearchMakH = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfNameInfo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfPhoneInfo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lbPoint = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfInputvoucher = new javax.swing.JTextField();
        btnapplyvoucher = new javax.swing.JButton();
        btnpayment = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfrefundMoney = new javax.swing.JTextField();
        tfinputmoneyclient = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableVoucher = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbTotalAmount = new javax.swing.JLabel();
        lbTotalVoucher = new javax.swing.JLabel();
        lbTotalPoint = new javax.swing.JLabel();
        LbTotalMoney = new javax.swing.JLabel();
        btnUsePoint = new javax.swing.JButton();
        btncancelusepoint = new javax.swing.JButton();
        btnCreateHoaDon = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfCodeHD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1400, 900));

        panelProduct.setPreferredSize(new java.awt.Dimension(1400, 850));

        tfSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfSearch.setPreferredSize(new java.awt.Dimension(64, 25));

        btnSearch.setText("Tìm kiếm");
        btnSearch.setAlignmentX(0.5F);
        btnSearch.setPreferredSize(new java.awt.Dimension(120, 25));
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
            .addGap(0, 112, Short.MAX_VALUE)
        );

        jScrollPane1.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(330, 402));

        TableSpDangBan.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        TableSpDangBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Ảnh Sản Phẩm ", "Tên Sản Phẩm", "Số Lượng", "Giá Bán", "Barcode"
            }
        ));
        jScrollPane1.setViewportView(TableSpDangBan);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel2.setText("Danh sách sản phẩm đang bán");

        jScrollPane2.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N

        TableTinhTien.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        TableTinhTien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane2.setViewportView(TableTinhTien);

        javax.swing.GroupLayout panelProductLayout = new javax.swing.GroupLayout(panelProduct);
        panelProduct.setLayout(panelProductLayout);
        panelProductLayout.setHorizontalGroup(
            panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelProductLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(385, 385, 385)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelProductLayout.setVerticalGroup(
            panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductLayout.createSequentialGroup()
                .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
        );

        pannelPayment.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        pannelPayment.setPreferredSize(new java.awt.Dimension(358, 850));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("MÃ KHÁCH HÀNG");

        tfInputMaKH.setPreferredSize(new java.awt.Dimension(64, 26));

        btnsearchMakH.setText("Tìm kiếm");
        btnsearchMakH.setPreferredSize(new java.awt.Dimension(113, 25));
        btnsearchMakH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchMakHActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên Khách Hàng");

        tfNameInfo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfNameInfo.setEnabled(false);
        tfNameInfo.setFocusable(false);
        tfNameInfo.setMinimumSize(new java.awt.Dimension(64, 25));
        tfNameInfo.setPreferredSize(new java.awt.Dimension(64, 25));

        jLabel5.setText("SĐT");

        tfPhoneInfo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfPhoneInfo.setEnabled(false);
        tfPhoneInfo.setMinimumSize(new java.awt.Dimension(64, 25));
        tfPhoneInfo.setPreferredSize(new java.awt.Dimension(64, 25));

        jLabel6.setText("Tổng điểm tích lũy:");

        lbPoint.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPoint.setForeground(new java.awt.Color(255, 0, 0));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("KHUYẾN MÃI");

        tfInputvoucher.setPreferredSize(new java.awt.Dimension(64, 25));

        btnapplyvoucher.setText("Áp dụng");
        btnapplyvoucher.setPreferredSize(new java.awt.Dimension(113, 25));
        btnapplyvoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnapplyvoucherActionPerformed(evt);
            }
        });

        btnpayment.setBackground(new java.awt.Color(0, 102, 102));
        btnpayment.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnpayment.setForeground(new java.awt.Color(255, 255, 255));
        btnpayment.setText("F2 - Thanh toán");
        btnpayment.setToolTipText("");
        btnpayment.setBorderPainted(false);
        btnpayment.setPreferredSize(new java.awt.Dimension(160, 39));
        btnpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpaymentActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("F1 - Hủy hoá đơn");
        btnCancel.setBorderPainted(false);
        btnCancel.setPreferredSize(new java.awt.Dimension(160, 39));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel9.setText("TRẢ LẠI KHÁCH");

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel10.setText("KHÁCH TRẢ");

        tfrefundMoney.setEnabled(false);
        tfrefundMoney.setPreferredSize(new java.awt.Dimension(64, 25));
        tfrefundMoney.setSize(new java.awt.Dimension(78, 25));

        tfinputmoneyclient.setPreferredSize(new java.awt.Dimension(64, 25));

        jScrollPane3.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jScrollPane3.setPreferredSize(new java.awt.Dimension(330, 100));

        tableVoucher.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jScrollPane3.setViewportView(tableVoucher);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("TỔNG CỘNG");

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("MÃ KHUYẾN MẠI");

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("SỬ DỤNG ĐIỂM");

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("THÀNH TIỀN");

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel15.setText("THÔNG TIN KHUYẾN MÃI ĐANG ÁP DỤNG");

        lbTotalAmount.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        lbTotalAmount.setText("0 VND");

        lbTotalVoucher.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        lbTotalVoucher.setText("0 VND");

        lbTotalPoint.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        lbTotalPoint.setText("0 VND");

        LbTotalMoney.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        LbTotalMoney.setText("0 VND");

        btnUsePoint.setText("Sử dụng điểm");
        btnUsePoint.setMinimumSize(new java.awt.Dimension(113, 23));
        btnUsePoint.setPreferredSize(new java.awt.Dimension(113, 23));
        btnUsePoint.setSize(new java.awt.Dimension(78, 25));
        btnUsePoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsePointActionPerformed(evt);
            }
        });

        btncancelusepoint.setText("Huỷ bỏ");
        btncancelusepoint.setPreferredSize(new java.awt.Dimension(113, 23));
        btncancelusepoint.setSize(new java.awt.Dimension(78, 25));
        btncancelusepoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelusepointActionPerformed(evt);
            }
        });

        btnCreateHoaDon.setBackground(new java.awt.Color(0, 102, 102));
        btnCreateHoaDon.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnCreateHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateHoaDon.setText("F5 - Tạo hoá đơn mới");
        btnCreateHoaDon.setPreferredSize(new java.awt.Dimension(170, 39));
        btnCreateHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pannelPaymentLayout = new javax.swing.GroupLayout(pannelPayment);
        pannelPayment.setLayout(pannelPaymentLayout);
        pannelPaymentLayout.setHorizontalGroup(
            pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelPaymentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannelPaymentLayout.createSequentialGroup()
                        .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pannelPaymentLayout.createSequentialGroup()
                                .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfInputvoucher, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pannelPaymentLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(tfPhoneInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfNameInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfInputMaKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnapplyvoucher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnsearchMakH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUsePoint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btncancelusepoint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pannelPaymentLayout.createSequentialGroup()
                                .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addGroup(pannelPaymentLayout.createSequentialGroup()
                                        .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel10))
                                        .addGap(22, 22, 22)
                                        .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfrefundMoney, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                            .addComponent(tfinputmoneyclient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(pannelPaymentLayout.createSequentialGroup()
                                                .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbTotalPoint)
                                                    .addComponent(LbTotalMoney)
                                                    .addComponent(lbTotalVoucher)
                                                    .addComponent(lbTotalAmount))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12))
                    .addGroup(pannelPaymentLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnpayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(pannelPaymentLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnCreateHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pannelPaymentLayout.setVerticalGroup(
            pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelPaymentLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfInputMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearchMakH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNameInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPhoneInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsePoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbPoint)
                    .addComponent(btncancelusepoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfInputvoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnapplyvoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbTotalAmount))
                .addGap(18, 18, 18)
                .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lbTotalVoucher))
                .addGap(18, 18, 18)
                .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbTotalPoint))
                .addGap(18, 18, 18)
                .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(LbTotalMoney))
                .addGap(40, 40, 40)
                .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tfinputmoneyclient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfrefundMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnCreateHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pannelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel1.setText("Tính tiền");

        tfCodeHD.setEnabled(false);
        tfCodeHD.setMinimumSize(new java.awt.Dimension(64, 25));
        tfCodeHD.setPreferredSize(new java.awt.Dimension(64, 25));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel7.setText("Mã Hoá Đơn:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCodeHD, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pannelPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodeHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pannelPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnpaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpaymentActionPerformed

    private void btnapplyvoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnapplyvoucherActionPerformed
        String mavoucher = tfInputvoucher.getText().trim().toLowerCase(); // hoặc toUpperCase()
        Object[][] data = VoucherDao.getAllVouchers();
        if (!tfInputvoucher.getText().trim().isEmpty()) {
            if (containsVoucherIgnoreCase(data, mavoucher) && checkVoucherApply(mavoucher)) {
                for (Object[] row : data) {
                    if (row.length > 0 && mavoucher.equalsIgnoreCase(row[0].toString())) {
                        Object mavoucherdb = row[0];
                        Object giamgiadb = row[4];
                        add_sp_to_tableviewVoucher(new Object[]{mavoucherdb, giamgiadb});
                        tfInputvoucher.setText("");
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mã khuyến mại không đúng hoặc đang được áp dụng trong hoá đơn này vui lòng kiểm tra lại");
            }
        }
        else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập mã khuyến mại");
        }
    }//GEN-LAST:event_btnapplyvoucherActionPerformed

    
    private void btnsearchMakHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchMakHActionPerformed
       if (!tfInputMaKH.getText().isEmpty()) {
            Object[] dataClient = ClientDao.getKhachHangBySoDienThoai(tfInputMaKH.getText());
           if (dataClient != null) {
                getClientInfobysearch(dataClient[0].toString(), dataClient[1].toString(), dataClient[2].toString());
           }
           else {
                getClientInfobysearch("", "", "");
                JOptionPane.showMessageDialog(null, "Khách hàng chưa đăng ký thông tin trên hệ thống vui lòng đăng ký trước khi thanh toán");
           }
            updateButtonUsePoint();
       }
       else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại khách hàng");
       }
    }//GEN-LAST:event_btnsearchMakHActionPerformed

    private void btnUsePointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsePointActionPerformed
        if (lbPoint.getText() != "0"){
            Point = PointGetClient;
            updateMoneyBillField(); 
            lbPoint.setText("0");
            btnUsePoint.setEnabled(false);
            Uicore.setcolerbutton(btnUsePoint, new java.awt.Color(0,102,102));
            btncancelusepoint.setEnabled(true);
            Uicore.setcolerbutton(btncancelusepoint, new java.awt.Color(255,0,0));
        }
    }//GEN-LAST:event_btnUsePointActionPerformed

    private void btncancelusepointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelusepointActionPerformed
        if (lbPoint.getText() == "0") {
            Point = "0";
            updateMoneyBillField();
            lbPoint.setText(PointGetClient);
            btnUsePoint.setEnabled(true);
            Uicore.setcolerbutton(btnUsePoint, new java.awt.Color(0,102,102));
            btncancelusepoint.setEnabled(false);
            Uicore.setcolerbutton(btncancelusepoint, new java.awt.Color(255,0,0));
        }
    }//GEN-LAST:event_btncancelusepointActionPerformed

    private void btnCreateHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateHoaDonActionPerformed
        MaHoaDon = FileUtils.generateCodeHD();
        tfCodeHD.setText(MaHoaDon);
        isMaHoaDon = true;
        setupButtonAll();
    }//GEN-LAST:event_btnCreateHoaDonActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        reset_panel_banHang();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        search_sp(tfSearch.getText());
    }//GEN-LAST:event_btnSearchActionPerformed
    
    
    
    private void reset_panel_banHang(){
        MaHoaDon = "";
        tfCodeHD.setText(MaHoaDon);
        isMaHoaDon = false;
        setupButtonAll();
        resetPayment();
        tfInputMaKH.setText("");
        getClientInfobysearch("", "", "");
        updateMoneyBillField();
        updateButtonUsePoint();
    }
    
    public void load_san_pham(){
        DefaultTableModel model = (DefaultTableModel) TableSpDangBan.getModel();
        model.setRowCount(0);
        tfSearch.setText("");
        reset_filter();
        setUptableView();  
        reset_panel_banHang();
    }
    
    private boolean containsVoucherIgnoreCase(Object[][] data, String mavoucher) {
        for (Object[] row : data) {
            if (row.length > 0 && mavoucher.equalsIgnoreCase(row[0].toString())) {
                return true;
            }
        }
        return false;
    }
    
    private void reset_filter(){
        TableRowSorter<DefaultTableModel> rowSorter;
        DefaultTableModel model = (DefaultTableModel) TableSpDangBan.getModel();
        rowSorter = new TableRowSorter<>(model);
        TableSpDangBan.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"));
    }
    
    private void setUpdisableTf(JTextField tfInput){
        tfInput.setEnabled(false); 
        tfInput.setDisabledTextColor(Color.BLACK); // đổi màu chữ khi disable
//        tfInput.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        tfInput.setBackground(new java.awt.Color(242,242,242));   // đổi màu nền khi disable
    }
    
    private void setupButtonAll(){
       if (isMaHoaDon) {
           btnsearchMakH.setEnabled(true);
           btnapplyvoucher.setEnabled(true);
           btnCancel.setEnabled(true);
           btnpayment.setEnabled(true);
           btnCreateHoaDon.setEnabled(false);
           btncancelusepoint.setEnabled(false);
       }else {
           btnsearchMakH.setEnabled(false);
           btnapplyvoucher.setEnabled(false);
           btnCancel.setEnabled(false);
           btnpayment.setEnabled(false);
           btnCreateHoaDon.setEnabled(true);
       }
       Uicore.setcolerbutton(btnCancel, new java.awt.Color(255,0,0));
       Uicore.setcolerbutton(btnpayment, new java.awt.Color(0,102,102));
       Uicore.setcolerbutton(btnsearchMakH, new java.awt.Color(0,102,102));
       Uicore.setcolerbutton(btnSearch, new java.awt.Color(0,102,102));
       Uicore.setcolerbutton(btnapplyvoucher, new java.awt.Color(0,102,102));
       Uicore.setcolerbutton(btnCreateHoaDon, new java.awt.Color(0,102,102));
       Uicore.setcolerbutton(btnUsePoint, new java.awt.Color(0,102,102));
       Uicore.setcolerbutton(btncancelusepoint, new java.awt.Color(255,0,0));
    }
    
    private void setupUI(){
       setupButtonAll();
       updateButtonUsePoint();
       setUpdisableTf(tfCodeHD);
       setUpdisableTf(tfNameInfo);
       setUpdisableTf(tfPhoneInfo);
       setUpdisableTf(tfrefundMoney);
       tfinputmoneyclient.addActionListener(e -> {
            totalrefundMoneyClient();
        });
       
       tfinputmoneyclient.addFocusListener(new FocusAdapter() {
        @Override
        public void focusLost(FocusEvent e) {
            totalrefundMoneyClient();
                }
        });
    }
    
    private void updateButtonUsePoint(){
       String NameInfo = tfNameInfo.getText();
       String PhoneInfo= tfPhoneInfo.getText();
       String iemInfo= lbPoint.getText();
       if (!NameInfo.isEmpty() && !PhoneInfo.isEmpty() && !iemInfo.isEmpty()){
            btnUsePoint.setVisible(true);
            btncancelusepoint.setVisible(true);
       }
       else {
            btnUsePoint.setVisible(false);
            btncancelusepoint.setVisible(false);
       }
    }
    
    private void search_sp (String str) {
        TableRowSorter<DefaultTableModel> rowSorter;
        DefaultTableModel model = (DefaultTableModel) TableSpDangBan.getModel();
        rowSorter = new TableRowSorter<>(model);
        TableSpDangBan.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
    }
    
    private void totalrefundMoneyClient(){
        if (!tfinputmoneyclient.getText().trim().isEmpty()){
            long totalmoneyclientpayment = Long.parseLong(tfinputmoneyclient.getText().toString().trim());
            long totalmoney = LbTotalMoney.getText().trim().isEmpty() ? 0 : Long.parseLong(LbTotalMoney.getText().replace(" VND", "").replace(",", "").trim());
            long totalmoneyrefundclientPayment = totalmoneyclientpayment - totalmoney;
            if (totalmoneyrefundclientPayment >= 0){
                tfrefundMoney.setText(FileUtils.formatVND(totalmoneyrefundclientPayment));
            }
            else {
                JOptionPane.showMessageDialog(null, "Số tiền khách trả không đủ"); 
            }
        }
        else {
            tfrefundMoney.setText("");
        }
    }
    
    public void reloadtableView(){
        DefaultTableModel model = (DefaultTableModel) TableSpDangBan.getModel();
        model.setRowCount(0);
        tfSearch.setText("");
        reset_filter();
        setUptableView(); 
    }
    
    private void setUptableView(){
        TableSpDangBan.setRowHeight(60); 
        TableSpDangBan.setShowHorizontalLines(true);
        TableSpDangBan.setShowVerticalLines(false);
        TableSpDangBan.setGridColor(Color.LIGHT_GRAY);
        TableSpDangBan.setDefaultEditor(Object.class, null);
        TableSpDangBan.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        DefaultTableModel model = (DefaultTableModel) TableSpDangBan.getModel();
        Object[][] data = ProductDao.getAllProductBanHang();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        // Thêm từng dòng dữ liệu vào bảng
        for (Object[] row : data) {
            model.addRow(row);
        }
        //căn giữa cho header
        JTableHeader header = TableSpDangBan.getTableHeader();
        for (int i = 0; i < TableSpDangBan.getColumnCount(); i++) {
            TableColumn column = TableSpDangBan.getColumnModel().getColumn(i);
            column.setHeaderRenderer(centerRenderer);
        }
        //căn giữa cho row
        for (int i = 0; i < TableSpDangBan.getColumnCount(); i++) {
            if (i != 1 && i!= 4) {
                TableSpDangBan.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }  
        TableSpDangBan.getColumnModel().getColumn(1).setCellRenderer(new ImageCellRenderer());
        FileUtils.applyRedTextOnSelect(TableSpDangBan, new int[]{1}, new int[]{4});
    }
    
    private void setUptableViewTinhTien(){
        TableTinhTien.setRowHeight(30); 
        TableTinhTien.setShowHorizontalLines(true);
        TableTinhTien.setShowVerticalLines(false);
        TableTinhTien.setGridColor(Color.LIGHT_GRAY);
        TableTinhTien.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        DefaultTableModel model = new DefaultTableModel(null, new Object[]{"Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Thành Tiền", ""}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2 || column == 5; // cho phép chỉnh sửa cột
            }
        };
        TableTinhTien.setModel(model);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        //căn giữa cho header
        JTableHeader header = TableTinhTien.getTableHeader();
        for (int i = 0; i < TableTinhTien.getColumnCount(); i++) {
            TableColumn column = TableTinhTien.getColumnModel().getColumn(i);
            column.setHeaderRenderer(centerRenderer);
        }
        model.addTableModelListener(e -> {
            int row = e.getFirstRow();
            int col = e.getColumn();
            if (col == 2) { // cột số lượng thay đổi
                int soLuong = Integer.parseInt(model.getValueAt(row, 2).toString());
                int giaBan = Integer.parseInt(model.getValueAt(row, 3).toString().replace(" VND", "").trim());
                int thanhTien = soLuong * giaBan;
                model.setValueAt(thanhTien, row, 4); // cập nhật lại thành tiền
                updateMoneyBillField();
            }
    });
    }      
        
    private void setUptableViewVoucher(){
        tableVoucher.setRowHeight(30); 
        tableVoucher.setShowHorizontalLines(true);
        tableVoucher.setShowVerticalLines(false);
        tableVoucher.setGridColor(Color.LIGHT_GRAY);
        tableVoucher.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 10));
        DefaultTableModel model = new DefaultTableModel(null, new Object[]{"Mã khuyến mại", "Số tiền giảm", ""}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2;// cho phép chỉnh sửa cột    
            }
        };
        tableVoucher.setModel(model);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        //căn giữa cho header
        JTableHeader header = tableVoucher.getTableHeader();
        for (int i = 0; i < tableVoucher.getColumnCount(); i++) {
            TableColumn column = tableVoucher.getColumnModel().getColumn(i);
            column.setHeaderRenderer(centerRenderer);
        }
        model.addTableModelListener(e -> {
        int row = e.getFirstRow();
        int col = e.getColumn();
        if (col == 2) { // cột số lượng thay đổi
            int giaBan = Integer.parseInt(model.getValueAt(row, 1).toString().replace(" VND", "").trim());
            model.setValueAt(giaBan, row, 1); // cập nhật lại thành tiền
        }
    });
}  
        
     private void remove_focus_table(){
        panelProduct.addMouseListener(new MouseAdapter() {
       @Override
       public void mousePressed(MouseEvent e) {
           TableTinhTien.clearSelection(); // bỏ chọn dòng
           TableTinhTien.requestFocusInWindow(); // chuyển focus đi
           TableSpDangBan.clearSelection(); 
           TableSpDangBan.requestFocusInWindow(); 
       }
        });
     }  
       
     
    private void add_sp_to_tableviewTinhTien(Object[] data) {
        DefaultTableModel model = (DefaultTableModel) TableTinhTien.getModel();
        model.addRow(data);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
         //căn giữa text
        for (int i = 0; i < TableTinhTien.getColumnCount(); i++) {
            if (i != 3 && i!= 4) {
                TableTinhTien.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }  
        FileUtils.applyRedTextOnSelect(TableTinhTien, new int[]{}, new int[]{3, 4});
        TableColumn actionCol = TableTinhTien.getColumnModel().getColumn(5);
        actionCol.setCellRenderer(new ButtonRenderer());
        actionCol.setCellEditor(new ButtonEditor(TableTinhTien));
        actionCol.setMaxWidth(60);
        updateMoneyBillField();
    }
    
    private void add_sp_to_tableviewVoucher(Object[] data) {
        DefaultTableModel model = (DefaultTableModel) tableVoucher.getModel();
        model.addRow(data);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
         //căn giữa text
        for (int i = 0; i < tableVoucher.getColumnCount(); i++) {
            if (i !=  1) {
                tableVoucher.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }  
        FileUtils.applyRedTextOnSelect(tableVoucher, new int[]{}, new int[]{1});
        TableColumn actionCol = tableVoucher.getColumnModel().getColumn(2);
        actionCol.setCellRenderer(new ButtonRenderer());
        actionCol.setCellEditor(new ButtonEditor(tableVoucher));
        actionCol.setMaxWidth(60);
        updateMoneyBillField();
    }
    
    private Boolean checkVoucherApply(String maVoucher){
        DefaultTableModel modelTableVoucher = (DefaultTableModel) tableVoucher.getModel();
         //Tính tổng tiền hàng   
        for (int i = 0; i < modelTableVoucher.getRowCount(); i++) {
            Object val = modelTableVoucher.getValueAt(i, 0); // cột mã voucher
            if (val.toString().equals(maVoucher.toUpperCase()) ){
                System.out.print("vào đây");
                return false;
            }
        }
        return true;
    }
    
    private void setupAddSp(){
        TableSpDangBan.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2 && TableSpDangBan.getSelectedRow() != -1) {
                if (isMaHoaDon) {
                    int row = TableSpDangBan.getSelectedRow();  // dòng được chọn
                    int colCount = TableSpDangBan.getColumnCount();
                    String maSp = TableSpDangBan.getValueAt(row, 0).toString();
                    String tenSp = TableSpDangBan.getValueAt(row, 2).toString();
                    String SoLuong = TableSpDangBan.getValueAt(row, 4).toString();
                    String GiaBan = TableSpDangBan.getValueAt(row, 4).toString();
                    add_sp_to_tableviewTinhTien(new Object[]{maSp, tenSp, 1, GiaBan, GiaBan});
                }
                else {
                    JOptionPane.showMessageDialog(null, "Vui lòng tạo hoá đơn mới trước khi thêm sản phẩm cần thanh toán"); 
                    }
                }
            }
        });
    }
    
    private void setupbidingButton(){
       FileUtils.bindKeyToButton(btnCancel, "F1");
       FileUtils.bindKeyToButton(btnpayment, "F2");
       FileUtils.bindKeyToButton(btnCreateHoaDon, "F5");
    }
    
    private void resetPayment(){
        DefaultTableModel modelTinhTien = (DefaultTableModel) TableTinhTien.getModel();
        modelTinhTien.setRowCount(0);
        
        DefaultTableModel modelVoucher = (DefaultTableModel) tableVoucher.getModel();
        modelVoucher.setRowCount(0);
        
        
    }
    
    private void getClientInfobysearch(String name, String phone, String diem){
        tfNameInfo.setText(name);
        tfPhoneInfo.setText(phone);
        lbPoint.setText(diem);
        PointGetClient = diem;
    }
    
    private void updateMoneyBillField() {
        DefaultTableModel modelTableTinhTien = (DefaultTableModel) TableTinhTien.getModel();
        int tongTien = 0;
        
        DefaultTableModel modelTableVoucher = (DefaultTableModel) tableVoucher.getModel();
        int tongVoucher = 0;
        
        int totalPoint = Point.trim().isEmpty() ? 0 : Integer.parseInt(Point.trim());
    
        
         //Tính tổng tiền hàng   
        for (int i = 0; i < modelTableTinhTien.getRowCount(); i++) {
            Object val = modelTableTinhTien.getValueAt(i, 4); // cột thành tiền
            if (val != null) {
                int tien = Integer.parseInt(val.toString().replace(",", "").trim());
                tongTien += tien;
            }
        }
        //Tính tổng tiền voucher
        for (int i = 0; i < modelTableVoucher.getRowCount(); i++) {
            Object val = modelTableVoucher.getValueAt(i, 1); // cột giảm giá
            if (val != null) {
                int voucher = Integer.parseInt(val.toString().replace(",", "").trim());
                tongVoucher += voucher;
            }
        }
        lbTotalAmount.setText(FileUtils.formatVND(tongTien));
        lbTotalVoucher.setText(FileUtils.formatVND(tongVoucher));
        lbTotalPoint.setText(FileUtils.formatVND(totalPoint));
        setupMoneyField(); //gọi lại hàm này để update cột thành tiền
        totalrefundMoneyClient();
        
    }
    
    private void setupMoneyField(){
        int tongcong = Integer.parseInt(lbTotalAmount.getText().toString().replace(" VND", "").replace(",", "").trim());
        int makhuyenmai = Integer.parseInt(lbTotalVoucher.getText().toString().replace(" VND", "").replace(",", "").trim());
        int tongdiem = Integer.parseInt(lbTotalPoint.getText().toString().replace(" VND", "").replace(",", "").trim());
        int thanhtien = tongcong - makhuyenmai - tongdiem;
        LbTotalMoney.setText(FileUtils.formatVND(thanhtien));
    }
 
    class ImageCellRenderer extends JLabel implements TableCellRenderer {
        public ImageCellRenderer() {
            setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa ngang
            setVerticalAlignment(SwingConstants.CENTER);   // Căn giữa dọc
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            ImageIcon icon_base64 = FileUtils.convert_base64_to_image((String) value, 50, 50);
            setIcon(icon_base64);
            setText(null); // Không hiển thị text
            return this;
        }
    }
    
    public class ButtonRenderer extends JButton implements TableCellRenderer {

       public ButtonRenderer() {
           setOpaque(true);
           setForeground(Color.RED);
           setText("X");
           setFocusPainted(false);
           setBorderPainted(false);
           setContentAreaFilled(false);
       }

       @Override
       public Component getTableCellRendererComponent(JTable table, Object value,
                                                      boolean isSelected, boolean hasFocus,
                                                      int row, int column) {
           return this;
       }
   }
    
    public class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private JTable table;

        public ButtonEditor(JTable table) {
            super(new JCheckBox());
            this.table = table;

            button = new JButton("X");
            button.setForeground(Color.RED);
            button.setFocusPainted(false);
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);

            button.addActionListener(e -> {
                int row = table.getEditingRow();
                if (row != -1) {
                    if (table.isEditing()) {
                     table.getCellEditor().stopCellEditing();
                    }
                    ((DefaultTableModel) table.getModel()).removeRow(row);
                    updateMoneyBillField();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return "X";
        }

        @Override
        public boolean isCellEditable(EventObject e) {
            return true;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbTotalMoney;
    private javax.swing.JTable TableSpDangBan;
    private javax.swing.JTable TableTinhTien;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreateHoaDon;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUsePoint;
    private javax.swing.JButton btnapplyvoucher;
    private javax.swing.JButton btncancelusepoint;
    private javax.swing.JButton btnpayment;
    private javax.swing.JButton btnsearchMakH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbPoint;
    private javax.swing.JLabel lbTotalAmount;
    private javax.swing.JLabel lbTotalPoint;
    private javax.swing.JLabel lbTotalVoucher;
    private javax.swing.JPanel panelProduct;
    private javax.swing.JPanel pannelPayment;
    private javax.swing.JTable tableVoucher;
    private javax.swing.JTextField tfCodeHD;
    private javax.swing.JTextField tfInputMaKH;
    private javax.swing.JTextField tfInputvoucher;
    private javax.swing.JTextField tfNameInfo;
    private javax.swing.JTextField tfPhoneInfo;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfinputmoneyclient;
    private javax.swing.JTextField tfrefundMoney;
    // End of variables declaration//GEN-END:variables
}
