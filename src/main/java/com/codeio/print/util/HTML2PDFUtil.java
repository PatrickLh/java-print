package com.codeio.print.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;

import com.openhtmltopdf.DOMBuilder;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

public class HTML2PDFUtil {
	
	public static void convert(String inputFile, String outputFile){
		OutputStream os = null;
		try {
			File input = new File(inputFile);
			Document doc = DOMBuilder.jsoup2DOM(Jsoup.parse(input, "UTF-8", ""));
			os = new FileOutputStream(outputFile);
			PdfRendererBuilder builder = new PdfRendererBuilder();
			// 设置中文字体，否则无法打印中文
			builder.useFont(new File("C:/Windows/Fonts/msyh.ttf"), "Microsoft YaHei");
			builder.withW3cDocument(doc, "");
			builder.toStream(os);
	        builder.run();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if (null!=os) {
					os.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
