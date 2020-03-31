package com.qj.error;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.stereotype.Component;

import com.qj.entity.ZuulEntity;
import com.qj.servie.MemberFeign;
import com.qj.servie.QZuulFeign;

import feign.hystrix.FallbackFactory;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;




@Component
@Slf4j
public class ZuulFeignService implements FallbackFactory<QZuulFeign>  {

	@Override
	public QZuulFeign create(Throwable arg0) {
		return new QZuulFeign() {

			@Override
			public String getAllZuul() {
				log.info("FEIGN >>> getAllZuul() 降级:"+arg0.getMessage());
				return "FEIGN >>> not Zuul Info";
			}

			@Override
			public Integer addZuul(ZuulEntity zuulEntity) {
				log.info("FEIGN >>> addZuul(ZuulEntity zuulEntity) 降级:"+arg0.getMessage());
				return null;
			}

			@Override
			public Integer updateZuul(ZuulEntity zuulEntity) {
				log.info("FEIGN >>> updateZuul(ZuulEntity zuulEntity) 降级:"+arg0.getMessage());
				return null;
			}

			@Override
			public Integer deleteZuul(String id) {
				log.info("FEIGN >>> deleteZuul(String id) 降级:"+arg0.getMessage());
				return null;
			}
			
		};


	}

}
