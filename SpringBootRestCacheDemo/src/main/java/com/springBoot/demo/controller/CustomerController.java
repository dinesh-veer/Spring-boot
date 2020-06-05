package com.springBoot.demo.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.demo.model.Customer;

@RestController
public class CustomerController {
	@GetMapping(path = "/customerInfo")
	@Cacheable(value="cacheCustInfo")
    public Customer customerInformation() {
		System.out.println("From Method call");
        Customer cust = new Customer();

        cust.setCustNo(100);
        cust.setName("Bank of America");
        cust.setCountry("United States");

        return cust;
	}
	
	@GetMapping("/removeCache")
	@CacheEvict(value = "cacheCustInfo", allEntries=true)
    public String removeEmployee() {
    
		return "removed from cache";
    }
}
