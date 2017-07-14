package com.codeio.print.util;

public class FileUtil {

	public static String getPath() {
		return FileUtil.class.getClassLoader().getResource("").getPath().substring(1);
	}
	
	public static String getTemplatePath() {
		return (FileUtil.class.getClassLoader().getResource("").getPath() + "temp").substring(1);
	}
	
	public static String getTempPath() {
		return (FileUtil.class.getClassLoader().getResource("").getPath() + "temp").substring(1);
	}
}
