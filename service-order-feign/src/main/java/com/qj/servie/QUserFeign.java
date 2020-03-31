package com.qj.servie;





import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qj.error.ZuulFeignService;

//fallback = MemberFeignService.class
@FeignClient(value = "service-member",fallbackFactory = ZuulFeignService.class)
public interface QUserFeign {

	
	@RequestMapping(value = "/user/queryUser" , method =RequestMethod.POST)
	public String queryUser(@RequestBody String requestText) ;
	

	
	
}
