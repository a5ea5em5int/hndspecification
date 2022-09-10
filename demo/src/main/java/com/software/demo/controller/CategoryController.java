package com.software.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.software.demo.entity.Category;
import com.software.demo.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService catService;
	
	@GetMapping("/categories")
	public String showAllCategories(Model model)
	{
		List<Category> categories = catService.findAllCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("title","Categories page");
		return "categories";
		
	}
	@GetMapping("/categories/newform")
	public String showCategoryForm(Model model)
	{
		Category category= new Category();
		model.addAttribute("category", category);
		model.addAttribute("title","Insert new category page");
		return "category";
		
	}
	@PostMapping("/categories/save")
	public String saveCategory(@ModelAttribute Category category)
	{
		catService.saveCategory(category);
		return "redirect:/categories";
	}
	
	@GetMapping("/categories/edit/{id}")
	public String showEditform(@PathVariable Integer id,Model model)
	{
		 Category category = catService.findById(id);
		 model.addAttribute("category", category);
		 return "edit_category";
	}
	@GetMapping("/categories/delete/{id}")
	public String deleteCategory(@PathVariable("id") Integer id)
	{	catService.delete(id);
		return "redirect:/categories";
		
	}
	
	@PostMapping("/categories/update")
	public String updateCategory(@ModelAttribute Category category)
	{	Integer id = category.getId();
		if (id==null) System.out.println("**********null**********8");
		Category oldcategory = catService.findById(id);
		oldcategory.setName(category.getName());
		catService.update(oldcategory);
		return "redirect:/categories";
	}
}