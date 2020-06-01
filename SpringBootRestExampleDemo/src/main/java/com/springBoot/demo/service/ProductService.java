package com.springBoot.demo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.springBoot.demo.model.Product;

@Service
public class ProductService {
	public static Map<Integer, Product> productMap = new HashMap<>();

	static {
		Product productOne = new Product();
		productOne.setId(1);
		productOne.setName("MEAL");
		productMap.put(productOne.getId(), productOne);

		Product producttwo = new Product();
		producttwo.setId(2);
		producttwo.setName("TEST");
		productMap.put(producttwo.getId(), producttwo);

	}

	public Collection<Product> getAllProducts() {
		return productMap.values();
	}

	public Product addProduct(Product product) {
		return productMap.put(product.getId(), product);

	}

	public int updateProduct(Product product) {
		if (productMap.containsKey(product.getId())) {
			productMap.put(product.getId(), product);
			return 1;
		} else
			return 0;
	}

	public boolean deleteProduct(Integer id) {
		if((productMap.containsKey(id))) {
			productMap.remove(id);
			return true;
		}
		return false;
	}

}
