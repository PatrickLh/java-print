package com.codeio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.codeio.print.config.ApplicationContextProvider;
import com.codeio.print.factory.PrinterFactory;
import com.codeio.print.thread.MonitorTask;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@PropertySource(value = { "config/application.properties" })
public class Application {
    public static void main(String[] args) {
    	PrinterFactory.initial();
        SpringApplication.run(Application.class, args);
        // 启动打印线程
        MonitorTask task = ApplicationContextProvider.getBean("printTask", MonitorTask.class);
    	task.start();
    }

}