package com.codeio.print.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;

public class ImageUtil {
	public static String getImageStr(String imageFile)  {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
        InputStream in = null;  
        byte[] data = null;  
        //读取图片字节数组  
        try {  
            in = new FileInputStream(imageFile);          
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        //对字节数组Base64编码  
        Base64 encoder = new Base64();  
        return encoder.encodeToString(data);//返回Base64编码过的字节数组字符串  
    }  
}
