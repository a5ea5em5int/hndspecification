package com.software.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.demo.entity.Product;
import com.software.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		List<Product> products = productRepo.findAll();
		return products;
	}

	@Override
	public void saveNewProduct(Product product) {
		productRepo.save(product);
		
	}

}
