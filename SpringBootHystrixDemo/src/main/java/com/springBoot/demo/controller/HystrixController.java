package com.springBoot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class HystrixController {

	@RequestMapping("/welcome")
	@HystrixCommand(fallbackMethod="fallback_method", 
					commandProperties= {
						@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1000")
					})
	public String welcomeMessage() throws InterruptedException {
		Thread.sleep(3000);
		return "Welcome message";
	}

	public String fallback_method() {
		return "from fallback method";
	}
	
}
