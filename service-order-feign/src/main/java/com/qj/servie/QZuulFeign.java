package com.qj.servie;

import java.util.List;



import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qj.entity.ZuulEntity;
import com.qj.error.ZuulFeignService;

//fallback = MemberFeignService.class
@FeignClient(value = "service-member",fallbackFactory = ZuulFeignService.class)
public interface QZuulFeign {

	
	@RequestMapping(value = "/zuul/getAllZuul" , method =RequestMethod.POST)
	public String getAllZuul() ;
	
	@RequestMapping(value = "/zuul/addZuul" , method =RequestMethod.POST)	
	Integer addZuul(ZuulEntity zuulEntity);
	
	@RequestMapping(value = "/zuul/updateZuul" , method =RequestMethod.POST)	
	Integer updateZuul(ZuulEntity zuulEntity);
	
	@RequestMapping(value = "/zuul/deleteZuul" , method =RequestMethod.POST)	
	Integer deleteZuul(@RequestBody String id);
	
	
}
