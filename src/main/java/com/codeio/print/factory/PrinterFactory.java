package com.codeio.print.factory;

import java.awt.print.PrinterJob;
import java.io.FileInputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

/**
 * 打印机容器获取，项目启动时静态加载获取当前电脑所有打印机服务
 * @author patrick.liu
 *
 */
public class PrinterFactory {
	
	static PrintService[] services;
	
	static PrintRequestAttributeSet aset;
	
	/**
	 * 初始化获取打印服务对象
	 */
	public static void initial() {
		// 获取所有打印机
		aset = new HashPrintRequestAttributeSet();
		services = PrintServiceLookup.lookupPrintServices(null, null);
	}
	
	/**
	 * 获取打印机对象
	 */
	public static PrintService getPrinter(String name) {
		PrintService printer = null;
		if (null!=services && null!= name) {
			for (int i = 0; i < services.length; i++) {
				System.out.println("service found: " + services[i]);
				String svcName = services[i].toString();
				if (svcName.equals(name)) {
					printer = services[i];
					System.out.println("my printer found: " + svcName);
					System.out.println("my printer found: " + printer);
					break;
				}
			}
		} else { // 使用默认打印机
			printer = PrintServiceLookup.lookupDefaultPrintService();
			System.out.println("my printer found: " + printer.toString());
			System.out.println("my printer found: " + printer);
			return printer;
		}
		return printer;
	}
	/**
	 * 打印非PDF使用
	 * @param name
	 * @param fis
	 */
	public static void print(String name, FileInputStream fis, DocFlavor flav) {
		// 由于初始化打印机服务存在问题，所以暂时设定为使用默认打印机进行打印
		PrintService printer = PrinterFactory.getPrinter(name);
		DocPrintJob job = printer.createPrintJob();//创建文档打印作业
		try {
			Doc doc = new SimpleDoc(fis, flav, null);
			job.print(doc, aset);//打印文档
		} catch (Exception pe) {
			pe.printStackTrace();
		}
	}
	/**
	 * 打印PDF专用
	 * @param name
	 * @param fis
	 * @throws Exception
	 */
	public static void printPDF(String name, FileInputStream fis){
		// 获取打印机
		PrintService printer = PrinterFactory.getPrinter(name);
		try {
			// 打印文档
			PDDocument document = PDDocument.load(fis);
	        PrinterJob job = PrinterJob.getPrinterJob();
	        job.setPageable(new PDFPageable(document));
	        job.setPrintService(printer);
	        job.print();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null!= fis) {
					fis.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
