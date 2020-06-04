package com.springBoot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SpringBootZulProxyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootZulProxyDemoApplication.class, args);
	}

}
