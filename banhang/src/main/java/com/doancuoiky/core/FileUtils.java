/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doancuoiky.core;

import com.doancuoiky.model.PaymentModel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.io.InputStream;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
/**
 *
 * @author phuongmd
 */
public class FileUtils {
    public static byte[] readFileToBytes(File file) throws IOException {
    try (FileInputStream fis = new FileInputStream(file);
         ByteArrayOutputStream bos = new ByteArrayOutputStream()) {

        byte[] buffer = new byte[1024];
        int readNum;

        while ((readNum = fis.read(buffer)) != -1) {
            bos.write(buffer, 0, readNum);
        }
        return bos.toByteArray();
    }
    }
    public static String convert_image_to_base64 (File file) {
        //hàm chuyền từ ảnh sang base64 để lưu db
        try {
            byte[] imageBytes = readFileToBytes(file);
            String image_upload_base64 = Base64.getEncoder().encodeToString(imageBytes);
            return image_upload_base64;
        } catch (IOException ex) {
            ex.printStackTrace();
        }return null;
    }
    
    public static ImageIcon convert_base64_to_image(String base64, int width, int height) {
        //hàm chuyền từ base64 sang ảnh để hiển thị trên UI
        try {
            byte[] imageBytes = Base64.getDecoder().decode(base64);
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
            Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
    //                        ImageIcon icon_base64 = FileUtils.convert_base64_to_image(image_upload_base64, 250, 250);  cách dùng
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void exportWithSaveDialog(JTable table, JFrame parentFrame) {
        //hàm chọn ra nơi lưu file excel và xuất excel
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu file Excel");

        // Gợi ý tên file
        fileChooser.setSelectedFile(new File("data.xlsx"));

        int userSelection = fileChooser.showSaveDialog(parentFrame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            // Đảm bảo đuôi file là .xlsx
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".xlsx")) {
                filePath += ".xlsx";
            }

            boolean success = exportTableToExcel(table, filePath);
            if (success) {
                JOptionPane.showMessageDialog(parentFrame, "Xuất Excel thành công:\n" + filePath);
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Xuất Excel thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static boolean exportTableToExcel(JTable table, String filePath) {
         //hàm xuất excel
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        TableModel model = table.getModel();

        // Tạo dòng tiêu đề, bỏ qua cột hình ảnh
        Row headerRow = sheet.createRow(0);
        int headerColIndex = 0;
        for (int col = 0; col < model.getColumnCount(); col++) {
            if (col == 1) continue; // bỏ cột hình ảnh
            Cell cell = headerRow.createCell(headerColIndex++);
            cell.setCellValue(model.getColumnName(col));
        }

        // Ghi dữ liệu, bỏ qua cột hình ảnh
        for (int row = 0; row < model.getRowCount(); row++) {
            Row excelRow = sheet.createRow(row + 1);
            int excelCol = 0;
            for (int col = 0; col < model.getColumnCount(); col++) {
                if (col == 1) continue;
                Object value = model.getValueAt(row, col);
                excelRow.createCell(excelCol++).setCellValue(value != null ? value.toString() : "");
            }
        }

        // Auto-size cột
        for (int i = 0; i < headerColIndex; i++) {
            sheet.autoSizeColumn(i);
        }

        // Ghi file
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            workbook.write(out);
            workbook.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
        
    public static com.itextpdf.text.Font getVietnameseFont(float size) throws Exception {
        InputStream fontStream = FileUtils.class.getResourceAsStream("/fonts/Roboto-Regular.ttf");

        BaseFont unicodeFont = BaseFont.createFont(
            "Roboto-Regular.ttf",               
            BaseFont.IDENTITY_H,
            BaseFont.EMBEDDED,
            true,
            fontStream.readAllBytes(),
            null
        );
        return new com.itextpdf.text.Font(unicodeFont, size);
    }
    
    public static com.itextpdf.text.Font getVietnameseFont() throws Exception {
        return getVietnameseFont(13); // mặc định size = 13
    }   
    
    public static boolean exportPaymentFromTable(JTable table, String filePath, PaymentModel paymentData) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Tiêu đề
            Paragraph title = new Paragraph("HÓA ĐƠN BÁN HÀNG", getVietnameseFont(16));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Ngày và tên khách hàng
            String DateNow = FileUtils.convertDateString( paymentData.getNgayThanhToan());
            document.add(new Paragraph("Ngày: " + DateNow, getVietnameseFont(13)));
            document.add(new Paragraph("Khách hàng: " + paymentData.getHoTen(), getVietnameseFont(13)));
            document.add(new Paragraph("Số điện thoại: " + paymentData.getSdt(), getVietnameseFont(13)));
            document.add(Chunk.NEWLINE);

            // Bảng hóa đơn
            PdfPTable pdfTable = new PdfPTable(4);
            pdfTable.setWidthPercentage(100);
            pdfTable.addCell(new PdfPCell(new Phrase("Tên sản phẩm", getVietnameseFont())));
            pdfTable.addCell(new PdfPCell(new Phrase("Số lượng", getVietnameseFont())));
            pdfTable.addCell(new PdfPCell(new Phrase("Đơn giá", getVietnameseFont())));
            pdfTable.addCell(new PdfPCell(new Phrase("Thành tiền", getVietnameseFont())));

            TableModel model = table.getModel();
            int rowCount = model.getRowCount();
            long tongTien = 0;

            for (int row = 0; row < rowCount; row++) {
                String tenSP = model.getValueAt(row, 1).toString(); 
                String sl = model.getValueAt(row, 2).toString();  
                String donGia = model.getValueAt(row, 3).toString();
                String thanhTien = model.getValueAt(row, 4).toString();
                
                pdfTable.addCell(new Phrase(tenSP, getVietnameseFont()));
                pdfTable.addCell(new Phrase(sl, getVietnameseFont()));
                pdfTable.addCell(new Phrase(formatVND(Long.parseLong(donGia)), getVietnameseFont()));
                pdfTable.addCell(new Phrase(formatVND(Long.parseLong(thanhTien)), getVietnameseFont()));
            }

            document.add(pdfTable);
            document.add(Chunk.NEWLINE);

            // Tổng tiền
            document.add(new Paragraph("Tổng tiền sản phẩm : " + formatVND(paymentData.getTongTienHang()), getVietnameseFont(13)));
            document.add(new Paragraph("Tổng giảm giá : " + formatVND(paymentData.getTongGiamGia()), getVietnameseFont(13)));
            document.add(new Paragraph("Tổng thanh toán : " + formatVND(paymentData.getTongDoanhThu()), getVietnameseFont(13)));
            document.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void exportPayment(JTable table, JFrame parentFrame, PaymentModel paymentData) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu hóa đơn");
        fileChooser.setSelectedFile(new File(paymentData.getMaThanhToan() + ".pdf"));

        int result = fileChooser.showSaveDialog(parentFrame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            if (!path.toLowerCase().endsWith(".pdf")) {
                path += ".pdf";
                selectedFile = new File(path); 
            }

            boolean success = exportPaymentFromTable(table, path, paymentData);
            if (success) {
                try {
                    Desktop.getDesktop().open(selectedFile); 
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(parentFrame, "Không thể mở file!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Xuất hóa đơn thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void applyRedTextOnSelect(JTable table, int[] skipColumns, int[] vndColumns) {
       DefaultTableCellRenderer customRenderer = new DefaultTableCellRenderer() {
           private final DecimalFormat vndFormat = new DecimalFormat("#,##0");

           @Override
           public Component getTableCellRendererComponent(JTable table, Object value,
                                                          boolean isSelected, boolean hasFocus,
                                                          int row, int column) {
               JLabel label = (JLabel) super.getTableCellRendererComponent(
                       table, value, isSelected, false, row, column);

               label.setHorizontalAlignment(SwingConstants.CENTER);
               label.setForeground(Color.BLACK);
               label.setBackground(Color.WHITE);
               label.setOpaque(true);

               boolean isCurrency = false;
               for (long vndCol : vndColumns) {
                   if (column == vndCol) {
                       isCurrency = true;
                       break;
                   }
               }
               if (isCurrency && value != null) {
                   try {
                       long price = Long.parseLong(value.toString());
                       label.setText(vndFormat.format(price) + " VND");
                   } catch (NumberFormatException e) {
                       // fallback
                       label.setText(value.toString());
                   }
               }

               if (isSelected) {
                   label.setForeground(Color.BLUE);
               }

               return label;
           }
       };

       for (int i = 0; i < table.getColumnCount(); i++) {
           boolean skip = false;
           for (int col : skipColumns) {
               if (i == col) {
                   skip = true;
                   break;
               }
           }
           if (!skip) {
               table.getColumnModel().getColumn(i).setCellRenderer(customRenderer);
           }
       }
   }
    
    public static String formatVND(long money){
        DecimalFormat vndFormat = new DecimalFormat("#,##0");
        return vndFormat.format(money) + " VND";
    }
    
    public static String generateCodeHD() {
        String prefix = "HD";
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(prefix);
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }

        return sb.toString().toUpperCase();
    }
    
    public static void bindKeyToButton(JButton button, String keyStrokeString) {
        InputMap inputMap = button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = button.getActionMap();

        String actionKey = "keyBind_" + keyStrokeString;

        inputMap.put(KeyStroke.getKeyStroke(keyStrokeString), actionKey);
        actionMap.put(actionKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.isEnabled()) {
                    button.doClick();
                }
            }
        });
    }
    public static Date parseDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 
            return sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
    public static void setDateFromString(JDateChooser dateChooser, String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date date = sdf.parse(dateStr);
            dateChooser.setDate(date);
        } catch (Exception e) {
            e.printStackTrace();
            // Bạn có thể hiển thị thông báo lỗi nếu cần
        }
    }
    
    public static String getFormattedDate(JDateChooser chooser) {
        Date date = chooser.getDate();
        if (date == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(date);
    }   
    
    public static KeyListener filterOnlyNumberDuong() {
        return new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '\b') {
                    e.consume(); 
                    JOptionPane.showMessageDialog(null, "Chỉ được nhập số nguyên dương!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
    }
    
    public static java.sql.Date getDateNow() {
        return new java.sql.Date(System.currentTimeMillis());
    }
    
    public static java.sql.Date getDate7DaysAgo() {
        LocalDate date = LocalDate.now().minusDays(7);
        return java.sql.Date.valueOf(date);
    }
    
    public static String convertDateString(Date sqlDate) {
        if (sqlDate == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(sqlDate);
    }
    
    public static java.sql.Date convertStringToDateSql(String input) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false); 
            Date parsed = sdf.parse(input); 

            return new java.sql.Date(parsed.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
}
