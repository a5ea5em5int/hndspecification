package com.software.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.software.demo.entity.Product;

@Service
public interface ProductService {
	
	List<Product> findAllProduct();
	void saveNewProduct(Product product);

}
