package com.codeio.print.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.codeio.print.service.PrintService;

/**
 * 独立的打印线程
 * @author patrick.liu
 *
 */
@Component("printTask")
@Scope("prototype")
public class MonitorTask extends Thread {

    @Autowired
    private PrintService printService;

    @Override
    public void run() {
		while(true){
    		System.out.println("线程:"+Thread.currentThread().getName()+"运行中.....");
	    	printService.queryPrintOrder();
	    	try {
	    		// 每隔10s中进行一次扫描并打印
	    		Thread.sleep(10000);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
		}
    }

}