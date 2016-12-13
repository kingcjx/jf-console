package com.atguigu.jf.console.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.jf.console.trigger.service.CreateExcelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class QuartzTest {

	@Autowired
	private CreateExcelService createExcelService;
	
	@Test
	public void testQuartz() {
		try {
			createExcelService.createExcel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
