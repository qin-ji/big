package com.qj.controller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.qj.entity.ZuulEntity;
import com.qj.servie.QZuulFeign;

@RequestMapping("/zuul")
@RestController
public class FeignZuulController {
	
	@Autowired
	private QZuulFeign zuulFeign;


	@RequestMapping("/getAllZuul")
	public String getAllZuul() {
		return zuulFeign.getAllZuul();
	}
	
	@RequestMapping(value="/updateZuul", method = RequestMethod.POST)
	public Integer  updateZuul(@RequestBody ZuulEntity zuulEntity) {
		return zuulFeign.updateZuul(zuulEntity);
	}	
		
	@RequestMapping("/addZuul")
	public Integer  addZuul(@RequestBody ZuulEntity zuulEntity) {
		return  zuulFeign.addZuul(zuulEntity);
	}
	
	@RequestMapping("/deleteZuul")
	public Integer  deleteZuul(@RequestBody String id) {
		String ids = JSONObject.parseArray(JSONObject.parseObject(id).get("id").toString(),String.class).get(0);
		return  zuulFeign.deleteZuul(ids);
	}

}
