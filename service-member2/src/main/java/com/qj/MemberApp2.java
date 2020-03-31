package com.qj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MemberApp2 {

	public static void main(String[] args) {
		SpringApplication.run(MemberApp2.class, args);
	}

}
