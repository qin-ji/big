package com.qj.face.email;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

//处理第三方发送邮件
@Slf4j
@Service
@Transactional
public class EmailServiceImpl implements EmailService {

	@Value("${msg.subject}")
	private String subject;
	@Value("${msg.text}")
	private String text;
	@Value("${spring.mail.username}")
	private String fromEmail;
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendMsg(JSONObject body) {
		// 处理发送邮件
		String email = body.getString("email");
		if (StringUtils.isEmpty(email)) {
			return;
		}
		log.info("消息服务平台发送邮件:{}开始", email);
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		// 来自账号 自己发自己
		simpleMailMessage.setFrom(fromEmail);
		// 发送账号
		simpleMailMessage.setTo(email);
		// 标题
		simpleMailMessage.setSubject(subject);
		// 内容
		simpleMailMessage.setText(text.replace("{}", email));
		// 发送邮件
		try {
			System.setProperty("java.net.preferIPv4Stack", "true");
			javaMailSender.send(simpleMailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("消息服务平台发送邮件:{}完成", email);
	}

}
