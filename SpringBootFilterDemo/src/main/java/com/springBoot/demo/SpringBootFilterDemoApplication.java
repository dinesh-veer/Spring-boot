package com.springBoot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootFilterDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFilterDemoApplication.class, args);
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getMessage() {
		return "Simple test";
	}

}
