package com.codeio.print.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.codeio.print.factory.PrinterFactory;
import com.codeio.print.model.Response;
import com.codeio.print.util.FreemarkerUtil;
import com.codeio.print.util.HTML2PDFUtil;
import com.codeio.print.util.HttpClientUtil;
import com.codeio.print.util.ImageUtil;
import com.codeio.print.util.QRCodeUtil;
import com.google.gson.Gson;

@Service
public class PrintService {

	@Value("${path.temp}")
    private String tempPath;
	
	@Value("${path.template}")
    private String templatePath;
	
	@Value("${cmd.wkhtmltopdf}")
	private String wkhtmltopdfCmd;
	
	@PostConstruct  
    public void  init(){  
		 FreemarkerUtil.init(templatePath);
    }
	
	public void printTicket(Integer orderId) {
		String url = "http://www.coffeepenny.cn/business/print/order/" + orderId;
		Gson gson = new Gson();
		Map<String, Object> root = new HashMap<String, Object>();
		// 根据传递需要打印的订单号，获取远程数据
		try {
			String responseStr = HttpClientUtil.doGet(url);
			Map<String, Object> map = gson.fromJson(responseStr, HashMap.class);
			// 给模板添加数据
			root.put("order", ((Map)map.get("data")));
			// 首先生成二维码图片为了给freemarker添加图片信息
			QRCodeUtil.createQRCode("http://www.coffeepenny.cn/wechat/status.html?order_id=" + orderId, 100, 100, tempPath + File.separator + orderId + ".gif");
			String base64Image = ImageUtil.getImageStr(tempPath + File.separator + orderId + ".gif");
			// 添加二维码地址
			root.put("qrcode", "data:image/gif;base64," + base64Image);
			FreemarkerUtil.analysisTemplate("ticket.ftlh", tempPath + File.separator + orderId + ".html", root);
			HTML2PDFUtil.convert(wkhtmltopdfCmd, tempPath + File.separator + orderId + ".html", tempPath + File.separator + orderId + ".pdf");
			PrinterFactory.printPDF(null, new FileInputStream(tempPath + File.separator + orderId + ".pdf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void queryPrintOrder() {
		try {
			// 只查找未打印的需要打印的订单数据
			String url = "http://www.coffeepenny.cn/business/order/all?printStatus=0&&status=2";
			Gson gson = new Gson();
			String responseStr = HttpClientUtil.doGet(url);
			Response res = gson.fromJson(responseStr, Response.class);
			List<Map> list = (List)res.getData();
			// 如果列表不为空，则进行小票打印
			if (null != list && !list.isEmpty()) {
				for(int i = 0; i< list.size(); i++) {
					String orderIdStr = ((Map)list.get(i).get("orderDto")).get("id").toString();
					Integer orderId = Integer.parseInt(orderIdStr.substring(0, orderIdStr.indexOf('.')));
					System.out.println("打印订单ID:" + orderId);
					this.printTicket(orderId);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
