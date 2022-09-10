package com.software.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.software.demo.entity.CartItem;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Integer>{
	
	

}
