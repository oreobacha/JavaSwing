/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doancuoiky.core;

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
import java.awt.Component;
import java.io.InputStream;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
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
    
    public static boolean exportInvoice(String filePath) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Tiêu đề
            Paragraph title = new Paragraph("HÓA ĐƠN BÁN HÀNG", getVietnameseFont(16));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph("Ngày: 09/05/2025", getVietnameseFont(13)));
            document.add(new Paragraph("Khách hàng: Nguyễn Văn A", getVietnameseFont(13)));
            document.add(Chunk.NEWLINE);

            // Bảng sản phẩm
            PdfPTable table = new PdfPTable(4); // 4 cột
            table.setWidthPercentage(100);
            table.addCell(new PdfPCell(new Phrase("Tên SP", getVietnameseFont())));
            table.addCell(new PdfPCell(new Phrase("SL", getVietnameseFont())));
            table.addCell(new PdfPCell(new Phrase("Đơn giá", getVietnameseFont())));
            table.addCell(new PdfPCell(new Phrase("Thành tiền", getVietnameseFont())));

            // Dữ liệu
            table.addCell(new PdfPCell(new Phrase("Sản phẩm A", getVietnameseFont())));
            table.addCell(new PdfPCell(new Phrase("2", getVietnameseFont())));
            table.addCell(new PdfPCell(new Phrase("50,000 VND", getVietnameseFont())));
            table.addCell(new PdfPCell(new Phrase("100,000 VND", getVietnameseFont())));

            table.addCell(new PdfPCell(new Phrase("Sản phẩm B", getVietnameseFont())));
            table.addCell(new PdfPCell(new Phrase("1", getVietnameseFont())));
            table.addCell(new PdfPCell(new Phrase("30,000 VND", getVietnameseFont())));
            table.addCell(new PdfPCell(new Phrase("30,000 VND", getVietnameseFont())));

            document.add(table);

            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("Tổng cộng: 130,000 VND", getVietnameseFont(13)));

            document.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void exportInvoiceWithSaveDialog(JFrame parentFrame) {
        //Hàm chọn nơi lưu hoá đơn
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu hóa đơn");
        fileChooser.setSelectedFile(new File("hoadon.pdf"));

        int result = fileChooser.showSaveDialog(parentFrame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            if (!path.toLowerCase().endsWith(".pdf")) {
                path += ".pdf";
            }

            boolean success = exportInvoice(path);
            if (success) {
                JOptionPane.showMessageDialog(parentFrame, "Tạo hóa đơn thành công:\n" + path);
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

               // Format tiền cho cột chỉ định
               boolean isCurrency = false;
               for (int vndCol : vndColumns) {
                   if (column == vndCol) {
                       isCurrency = true;
                       break;
                   }
               }
               if (isCurrency && value != null) {
                   try {
                       int price = Integer.parseInt(value.toString());
                       label.setText(vndFormat.format(price) + " VND");
                   } catch (NumberFormatException e) {
                       // fallback
                       label.setText(value.toString());
                   }
               }

               // ✨ Màu chữ đỏ khi chọn
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
    
}
