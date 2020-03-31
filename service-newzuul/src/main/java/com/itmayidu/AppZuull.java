package com.itmayidu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableHystrixDashboard
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class AppZuull {

	 public static void main(String[] args) {
		SpringApplication.run(AppZuull.class, args);
	}
	
}
