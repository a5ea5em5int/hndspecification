package com.software.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.software.demo.entity.Category;

@Service
public interface CategoryService {
	
	List<Category> findAllCategories();
	void saveCategory(Category category);
	Category findById(Integer id);
	void update(Category category);
	void delete(Integer id);

}
