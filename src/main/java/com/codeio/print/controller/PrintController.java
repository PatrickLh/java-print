package com.codeio.print.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeio.print.service.PrintService;

@RestController
@RequestMapping(path = "/print")
public class PrintController {
	
	@Autowired
	private PrintService printService;
	
    @RequestMapping(value="/order/{orderId}" , method = RequestMethod.GET)
    @ResponseBody
    public void print(@PathVariable Integer orderId) throws Exception{
    	// 根据模板生成html文件
    	printService.printTicket(orderId);
    }
}
