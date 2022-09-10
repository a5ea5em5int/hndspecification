package com.software.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.software.demo.entity.CartItem;
import com.software.demo.entity.Product;
import com.software.demo.entity.User;
import com.software.demo.repo.ProductRepo;
import com.software.demo.repo.UserRepo;
import com.software.demo.service.CartItemInterface;

@Controller
public class CartItemController {
	
	@Autowired
	private CartItemInterface cinface;
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/showform")
	public String showForm(Model model)
	{	model.addAttribute("cartitem", new CartItem());
		List<User> users = userRepo.findAll();
		List<Product> products = productRepo.findAll();
		System.out.print("*****************************************"+users.size());
		System.out.print("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+products.size());
		model.addAttribute("products", products);
		model.addAttribute("users", users);
		return "cart_item";
		
	}
	
	@GetMapping("/cartitems")
	public String showAll(Model model)
	{
		List<CartItem> cartItems = cinface.showAll();
		for(CartItem cart : cartItems)
		{
			System.out.println(cart.getQuantity() +"  "+cart.getProduct().getName()+"    "+cart.getUser().getName());
		}
		model.addAttribute("cartitems", cartItems);
		return "cart_item2";
	}
	
	@PostMapping("/cartitems/save")
	public String saveItem(CartItem item)
	{	cinface.saveCartItem(item);
		System.out.println("in save method 4444444444444444444444444444444");
		
		return "redirect:/cartitems";
		
	}
	

}
