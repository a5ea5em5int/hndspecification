package com.software.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.demo.entity.Category;
import com.software.demo.entity.Product;
import com.software.demo.repo.CategoryRepo;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public List<Category> findAllCategories() {
		
		List<Category> categories = categoryRepo.findAll();
		return categories;
		
	}

	@Override
	public void saveCategory(Category category) {

		categoryRepo.save(category);
		
	}

	@Override
	public Category findById(Integer id) {
		Category category = categoryRepo.findById(id).get();
		return category;
	}

	@Override
	public void update(Category category) {
		categoryRepo.save(category);
		
	}

	@Override
	public void delete(Integer id) {
		categoryRepo.deleteById(id);
		
	}

}
