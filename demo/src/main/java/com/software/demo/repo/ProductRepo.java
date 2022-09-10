package com.software.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.software.demo.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}
