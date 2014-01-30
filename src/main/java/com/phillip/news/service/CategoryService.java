package com.phillip.news.service;

import java.util.List;

import com.phillip.news.domain.Category;
import com.phillip.news.domain.Language;

public interface CategoryService {
	Category persist(Category category);
	
	List<Category> findAll();
	List<Category> findAllCategories();
	
	Category findById(Long id);
	Category findByQualifiedName(String qualifiedName);
	List<Category> findById(List<Long> ids);
}
