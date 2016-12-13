package com.atguigu.jf.console.test.sendmail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.jf.console.trigger.service.SendEmailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SendMailTest {
	
	@Autowired
	private SendEmailService emailService;

	@Test
	public void testSendMail() throws Exception {
			emailService.sendEmail(null);
		
	}
}
