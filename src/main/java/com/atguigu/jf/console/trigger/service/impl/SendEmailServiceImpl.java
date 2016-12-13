package com.atguigu.jf.console.trigger.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

import com.atguigu.jf.console.trigger.service.SendEmailService;

@Service
public class SendEmailServiceImpl implements SendEmailService {

	@Override
	public void sendEmail(String file) throws Exception {
		/**
		 * 通过session创建文件的配置信息 创建邮件内容的message信息(MIME协议)
		 * 创建Transport对象、连接服务器、发送message、关闭连接
		 */
		// 1、使用session创建文件配置信息
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.sina.com");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.auth", "true");
		// 通过getInstance来加载配置
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);
		// 2、创建Message对象
		MimeMessage message = new MimeMessage(session);
		// 发件人
		message.setFrom(new InternetAddress("cuijinxin12345@sina.com"));
		// 收件地址
		message.setRecipient(RecipientType.TO, new InternetAddress(	"cuijinxin12345@sina.com"));
		String subject = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
		message.setSubject("您好，" + subject + "的报表");
		// 3、指定附件
			MimeMultipart mulpart = new MimeMultipart();
			// 3.1、先加入文本
			MimeBodyPart bodypart = new MimeBodyPart();
			bodypart.setContent("<span style='color:red;'>金鑫</span>，请查收！","text/html;charset=utf-8;");
			mulpart.addBodyPart(bodypart);
			// 3.2、加入附件
			bodypart = new MimeBodyPart();
			bodypart.setDataHandler(new DataHandler(new FileDataSource(new File(file))));
			bodypart.setFileName(new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".xls");
			mulpart.addBodyPart(bodypart);
			// 3.3、最终将MimeMultipart放入到message中
			message.setContent(mulpart);
		
		/**
		 * 3、创建Transport对象、连接服务器、发送Message、关闭连接
		 */
		Transport tran = session.getTransport();
		tran.connect("smtp.sina.com", "cuijinxin12345@sina.com", "abc464583");
		tran.sendMessage(message, message.getAllRecipients());
		tran.close();
	}
}
