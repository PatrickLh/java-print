package com.codeio.print.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class QRCodeUtil {
	private static final int BLACK = 0xFF000000;  
    private static final int WHITE = 0xFFFFFFFF;  
  
    private QRCodeUtil() {  
    }  
  
    public static BufferedImage toBufferedImage(BitMatrix matrix) {  
        int width = matrix.getWidth();  
        int height = matrix.getHeight();  
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        for (int x = 0; x < width; x++) {  
            for (int y = 0; y < height; y++) {  
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);  
            }  
        }  
        return image;  
    }  
  
    public static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {  
        BufferedImage image = toBufferedImage(matrix);  
        if (!ImageIO.write(image, format, file)) {  
            throw new IOException("Could not write an image of format " + format + " to " + file);  
        }  
    }  
  
    public static void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {  
        BufferedImage image = toBufferedImage(matrix);  
        if (!ImageIO.write(image, format, stream)) {  
            throw new IOException("Could not write an image of format " + format);  
        }  
    }
    
    public static void createQRCode(String text, int width, int height, String fileName) throws Exception{
        String format = "gif";// 二维码的图片格式  
        Map<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();  
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");   // 内容所使用字符集编码  
        hints.put(EncodeHintType.MARGIN, "0"); // 设置白边大小，然并暖（似乎是设置barcode的和qrcode没关系）
        
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);  
        // 生成二维码文件 
        File outputFile = new File(fileName);  
        QRCodeUtil.writeToFile(bitMatrix, format, outputFile);  
    }
}
