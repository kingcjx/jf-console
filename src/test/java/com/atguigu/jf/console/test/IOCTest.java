package com.atguigu.jf.console.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.jf.console.login.controller.LoginController;

public class IOCTest {

	
	@Test
	public void IOCTest(){
		ApplicationContext ioc  =new ClassPathXmlApplicationContext("spring-mvc.xml");
		LoginController bean = ioc.getBean(LoginController.class);
		System.out.println(bean);
	}
	
}
