package com.qj.controller;



import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.qj.entity.UserEntity;
import com.qj.service.QUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	@Value("${server.port}")
	private String serverPort;

	@Autowired
	private QUserService userService;

	@RequestMapping("/queryUser")
	public List<UserEntity> queryUser(@RequestBody String requestText) {
		 List<UserEntity> userList = new ArrayList<>();
		 userList = userService.queryUser(requestText);
		log.info(" SERVICE-MEMBER >>>  端口:"+ serverPort +" ,方法:user >>> queryUser ,响应信息 : "+JSONObject.toJSONString(userList) );
		return userList;
	}
	
}
