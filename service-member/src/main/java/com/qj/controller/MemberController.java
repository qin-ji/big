package com.qj.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MemberController {
	@Value("${server.port}")
	private String serverPort;

	
	@RequestMapping("/getMemberAll")
	public List<String> getMemberAll(String diaoyonzhe) {
		
		List<String> listUser = new ArrayList<String>();
		listUser.add("zhangsan");
		listUser.add("lisi");
		listUser.add("wangwu");
		listUser.add("serverPort:" + serverPort);
		log.info(" SERVICE-MEMBER >>>  端口:"+ serverPort +" ,方法:getMemberAll ,响应信息 : "+JSONObject.toJSONString(listUser) );
		return listUser;
	}

	
	

}
