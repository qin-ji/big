package com.qj.face.email;

import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

// 统一发送消息接口
public interface EmailService {
	
	public void sendMsg(JSONObject body);
}
