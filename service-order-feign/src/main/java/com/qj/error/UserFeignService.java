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

import com.qj.servie.QUserFeign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;




@Component
@Slf4j
public class UserFeignService implements FallbackFactory<QUserFeign>  {@Override
	public QUserFeign create(Throwable cause) {
		return new QUserFeign() {
			@Override
			public String queryUser(String requestText) {
				log.info("FEIGN >>> queryUser(String requestText) 降级:"+cause.getMessage());
				return null;
			}
		};
	}


}
