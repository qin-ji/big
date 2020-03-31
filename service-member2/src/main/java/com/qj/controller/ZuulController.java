package com.qj.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.qj.dao.ZuulDao;
import com.qj.entity.ZuulEntity;
import com.qj.service.QZuulService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/zuul")
public class ZuulController {
	@Value("${server.port}")
	private String serverPort;

	@Autowired
	private QZuulService zuulService;

	
	@RequestMapping("/getAllZuul")
	public String  getAllZuul() {
		List<ZuulEntity>  zuulList = zuulService.getZuulAll();
		log.info(" SERVICE-MEMBER >>>  端口:"+ serverPort +" ,方法:getAllZuul ,响应信息 : "+JSONObject.toJSONString(zuulList) );
		return JSONObject.toJSONString(zuulList);
	}

	@RequestMapping(value="/updateZuul", method = RequestMethod.POST)
	public Integer  updateZuul(@RequestBody ZuulEntity zuulEntity) {
		System.out.println(JSONObject.toJSONString(zuulEntity));
		Integer result = zuulService.updateZuul(zuulEntity);
		log.info(" SERVICE-MEMBER >>>  端口:"+ serverPort +" ,方法:updateZuul ,响应信息 : "+ result);
		return result;
	}
	

	@RequestMapping(value="/addZuul", method = RequestMethod.POST)
	public Integer  addZuul(@RequestBody ZuulEntity zuulEntity) {
		
		Integer result = zuulService.addZuul(zuulEntity);
		log.info(" SERVICE-MEMBER >>>  端口:"+ serverPort +" ,方法:addZuul ,响应信息 : "+ result);
		return result;
	}
	@RequestMapping(value="/deleteZuul", method = RequestMethod.POST)
	public Integer  deleteZuul(@RequestBody String id) {
		 zuulService.deleteZuul(id);
		log.info(" SERVICE-MEMBER >>>  端口:"+ serverPort +" ,方法:deleteZuul ,响应信息 : "+ 1);
		return 1;
	}

}
