package com.qj.controller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.qj.entity.ZuulEntity;
import com.qj.servie.QUserFeign;
import com.qj.servie.QZuulFeign;

@RequestMapping("/user")
@RestController
public class FeignUserController {
	
	@Autowired
	private QUserFeign userFeign;


	@RequestMapping("/queryUser")
	public String queryUser(@RequestBody String requestText) {
		return userFeign.queryUser(requestText);
	}
	
	

}
