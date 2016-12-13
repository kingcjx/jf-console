package com.atguigu.jf.console.trigger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.atguigu.jf.console.trigger.service.CreateExcelService;
import com.atguigu.jf.console.trigger.service.SendEmailService;

public class TriggerService {

	@Autowired
	private CreateExcelService createExcelService; 
	@Autowired
	private SendEmailService emailService;
	
	public void doIt() throws Exception{
		String file = createExcelService.createExcel();
		System.out.println("建表成功。。");
		emailService.sendEmail(file);
		System.out.println("发送邮件成功。。");
	}
}
