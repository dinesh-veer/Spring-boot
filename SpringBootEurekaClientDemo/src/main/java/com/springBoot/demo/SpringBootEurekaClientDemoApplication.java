package com.springBoot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringBootEurekaClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEurekaClientDemoApplication.class, args);
	}
	
	@RequestMapping("/index")
	public String getMessage() {
		return "this is rest message";
	}
	
	

}
