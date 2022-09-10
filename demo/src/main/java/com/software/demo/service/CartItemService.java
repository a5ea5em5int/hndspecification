package com.software.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.software.demo.entity.CartItem;
import com.software.demo.entity.Product;
import com.software.demo.entity.User;
import com.software.demo.repo.CartItemRepo;

@Service
public class CartItemService implements CartItemInterface {

	@Autowired
	private CartItemRepo cartRepo;

	@Override
	public void saveCartItem(CartItem cartitem) {
		cartRepo.save(cartitem);	
		System.out.println("save cart items in service-----------------------------");
	}

	@Override
	public List<CartItem> showAll() {
		List<CartItem> cartitems = cartRepo.findAll();
		
		return cartitems;
	}

}
