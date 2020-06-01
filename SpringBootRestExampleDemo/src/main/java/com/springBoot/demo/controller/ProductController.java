package com.springBoot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/products")
	public ResponseEntity<Object> getProduts(){
		return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
	}
}
