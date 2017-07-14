package com.codeio.print.util;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * 利用Freemarker构建小票和标签打印内容
 * @author patrick.liu
 *
 */
public class FreemarkerUtil {
	
	private static Configuration cfg;
	
	public static void init(String templatePath){
		try {
			// Create your Configuration instance, and specify if up to what FreeMarker
			// version (here 2.3.25) do you want to apply the fixes that are not 100%
			// backward-compatible. See the Configuration JavaDoc for details.
			cfg = new Configuration(Configuration.VERSION_2_3_25);
	
			// Specify the source where the template files come from. Here I set a
			// plain directory for it, but non-file-system sources are possible too:
			cfg.setDirectoryForTemplateLoading(new File(templatePath));
	
			// Set the preferred charset template files are stored in. UTF-8 is
			// a good choice in most applications:
			cfg.setDefaultEncoding("UTF-8");
	
			// Sets how errors will appear.
			// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	
			// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
			cfg.setLogTemplateExceptions(false);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 分析模板
	 * @param templateName 模板名
	 * @param root 模板数据
	 * @throws Exception
	 */
	public static void analysisTemplate(String templateName, String fileName, Map<?,?> root){  
		Writer out = null;
		try {
			// 获取模板
			Template temp = cfg.getTemplate(templateName, "UTF-8");
			out = new FileWriter(new File(fileName));
			// 输出模板内容
			temp.process(root, out);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if (null!=out) {
					out.close();
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
