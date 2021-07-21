package com.sapient.eldorado.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.eldorado.entities.Product;
import com.sapient.eldorado.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@GetMapping("/")
	public String hello() {
		return "Hello";
	}
	
	@PostMapping("/admin/product")
	public void addProduct(@RequestBody Product product) {
//		System.out.println(product);
		productservice.addProductService(product);
//		productRepository.save(new Product(product.getName(),product.getDesc(),product.getCategory(),product.getPrice(),product.getQuantity(),product.getImageLinks(),product.getVideoLinks(),product.getPdfLink()));
	}

}
