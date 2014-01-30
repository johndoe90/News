package com.phillip.news.service.impl;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;



/*@Service
public class CategoryServiceImpl implements CategoryService{

	@PersistenceContext
	private EntityManager em;
	
	private final CategoryRepository categoryRepository;
	
	@Inject
	public CategoryServiceImpl(CategoryRepository categoryRepository){
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category persist(Category category) {
		Assert.notNull(category);
		
		return categoryRepository.save(category);
	}

	@Override
	public Category findByQualifiedName(String qualifiedName) {
		Assert.hasText(qualifiedName);
		
		return categoryRepository.findByQualifiedName(qualifiedName);
	}

	@Override
	public Category findById(Long id) {
		Assert.notNull(id);
		
		return categoryRepository.findById(id);
	}

	@Override
	public List<Category> findById(List<Long> ids) {
		Assert.notEmpty(ids);
		
		return categoryRepository.findByIdIn(ids);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public List<Category> findAllCategories() {
		return categoryRepository.findAllCategories();
	}
}*/
