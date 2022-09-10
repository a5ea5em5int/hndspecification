package com.software.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.software.demo.entity.CartItem;
import com.software.demo.entity.Product;
import com.software.demo.entity.User;

@Service
public interface CartItemInterface {
	
	void saveCartItem(CartItem cartitem);
	List<CartItem> showAll();

}
