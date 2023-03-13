package com.exam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exam.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query("Select c from Category c where c.cid=:cid")
	public Optional<Category> findById(@Param(value="cid")Long cid);
@Query("Select c from Category c where c.title=:title")
	public Category findByTitle(@Param(value="title")String title);
}
