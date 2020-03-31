package com.itmayidu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmayidu.service.RefreshRouteService;

@RestController
public class ZuulController {

	@Autowired
	private RefreshRouteService refreshRouteService;
	
	/**
	 * 获取最新添加的路由,其实我感觉没什么卵用,因为他自己会刷新
	 * 
	 */
	@RequestMapping("/getNewZull")
	public void getMemberServiceApi() {
		refreshRouteService.refreshRoute();
	}
}
