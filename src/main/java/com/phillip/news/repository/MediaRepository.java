package com.phillip.news.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.phillip.news.domain.Media;

public interface MediaRepository extends JpaRepository<Media, Long>{
	Media findByUrl(String url);
}
