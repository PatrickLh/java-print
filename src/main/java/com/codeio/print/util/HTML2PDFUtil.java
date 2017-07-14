package com.codeio.print.util;

import java.io.OutputStream;

public class HTML2PDFUtil {
	// 指定安装的命令位置
	private static final String toPdfTool = "C:\\Program Files\\wkhtmltopdf\\\bin\\wkhtmltopdf.exe";
	/**
	 * 方案一：存在字体转换以及打印pdf边框设置的坑
	 */
//	public static void convert(String inputFile, String outputFile){
//		OutputStream os = null;
//		try {
//			File input = new File(inputFile);
//			Document doc = DOMBuilder.jsoup2DOM(Jsoup.parse(input, "UTF-8", ""));
//			os = new FileOutputStream(outputFile);
//			PdfRendererBuilder builder = new PdfRendererBuilder();
//			// 设置中文字体，否则无法打印中文
//			builder.useFont(new File("C:/Windows/Fonts/msyh.ttf"), "微软雅黑");
//			builder.useFont(new File("C:/Windows/Fonts/msyh.ttc"), "微软雅黑");
//			builder.withW3cDocument(doc, "");
//			builder.toStream(os);
//	        builder.run();
//		} catch (Exception e){
//			e.printStackTrace();
//		} finally {
//			try {
//				if (null!=os) {
//					os.close();
//				}
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
	/**
	 * 方案二：使用wkhtmltopdf解决转换问题，真的perfect
	 */
	public static void convert(String wkhtmltopdfCmd, String inputFile, String outputFile){
		StringBuilder cmd = new StringBuilder();
		cmd.append(wkhtmltopdfCmd);
		cmd.append(" -L 0"); // 设置左边距为0
		cmd.append(" -T 0"); // 设置上边距为0
		cmd.append(" ");
		cmd.append(inputFile);
		cmd.append(" ");
		cmd.append(outputFile);
		try {
			Process proc = Runtime.getRuntime().exec(cmd.toString());
			proc.waitFor();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
