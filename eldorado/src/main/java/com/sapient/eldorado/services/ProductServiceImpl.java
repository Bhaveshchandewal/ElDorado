package com.sapient.eldorado.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.sapient.eldorado.entities.Product;
import com.sapient.eldorado.repositories.ProductRepository;

public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;

	@Override
	public void addProductService(Product product) {
		// TODO Auto-generated method stub
		System.out.println(product);
		productRepository.save(new Product(product.getName(),product.getDesc(),product.getCategory(),product.getPrice(),product.getQuantity(),product.getImageLinks(),product.getVideoLinks(),product.getPdfLink()));
	}
	
}
