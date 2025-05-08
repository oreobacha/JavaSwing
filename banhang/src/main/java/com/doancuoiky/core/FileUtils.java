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
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
        try {
            byte[] imageBytes = readFileToBytes(file);
            String image_upload_base64 = Base64.getEncoder().encodeToString(imageBytes);
            return image_upload_base64;
        } catch (IOException ex) {
            ex.printStackTrace();
        }return null;
    }
    
        public static ImageIcon convert_base64_to_image(String base64, int width, int height) {
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
}
