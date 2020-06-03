package com.springBoot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/index")
	public String welcomePage() {
		return "index";
	}
	
	@RequestMapping("/view-products")
	public String viewproducts() {
		return "view-products";
	}
	
	@RequestMapping("/add-product")
	public String addProduct() {
		return "add-product";
	}
}
/**
 * 
To run the JSP page:

To have this in pom.xml

<!-- JSP -->
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
    <scope>provided</scope>
</dependency>
<!-- jstl for jsp -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
</dependency>
It may be not enough.

You must not miss this.

<packaging>war</packaging>
**/