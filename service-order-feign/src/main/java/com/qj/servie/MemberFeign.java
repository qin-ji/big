package com.qj.servie;

import java.util.List;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qj.error.MemberFeignService;

//fallback = MemberFeignService.class
@FeignClient(value = "service-member")
public interface MemberFeign {
	
	@RequestMapping("/getMemberAll")
	public List<String> getOrderByUserList();
	
	@RequestMapping(value = "/zuul/getAllZuul" , method =RequestMethod.POST)
	public String getAllZuul() ;
	
}
