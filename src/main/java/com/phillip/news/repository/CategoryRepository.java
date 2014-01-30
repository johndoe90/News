package com.phillip.news.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phillip.news.domain.Category;
import com.phillip.news.domain.Language;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	Category findById(Long id);
	Category findByQualifiedName(String qualifiedName);
	List<Category> findByIdIn(List<Long> ids);

	@Query("SELECT DISTINCT category FROM Category as category LEFT JOIN FETCH category.translations ORDER BY category.sort ASC")
	List<Category> findAllCategories();
}
