package com.codeio.print.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.codeio.print.service.PrintService;

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
	    		// 每隔1min中进行一次扫描并打印
	    		Thread.sleep(60000);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
		}
    }

}