package com.software.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.software.demo.entity.Category;
import com.software.demo.entity.Product;
import com.software.demo.service.CategoryService;
import com.software.demo.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService pservice;
	@Autowired
	private CategoryService cservice;
	@GetMapping("/")
	public String hello()
	{
		return "hello";
	}

	@GetMapping("/products")
	public String showProducts(Model model)
	{	List<Product> products = pservice.findAllProduct();
		model.addAttribute("products", products);
		model.addAttribute("title", "Produt List");
		return "products";
	}
	@GetMapping("/products/newform")
	public String showProductForm(Model model)
	{	Product product= new Product();
		List<Category> categories = cservice.findAllCategories();
		model.addAttribute("product",product);
		model.addAttribute("categories",categories);
		model.addAttribute("title", "Insert New Product");
		return "product";
	}
	@PostMapping("/products/save")
	public String saveProduct(@ModelAttribute Product product)
	{	
		
		pservice.saveNewProduct(product);
		return "redirect:/products";
	}
}
