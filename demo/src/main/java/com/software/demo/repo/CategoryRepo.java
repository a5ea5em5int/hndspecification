package com.software.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.software.demo.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
