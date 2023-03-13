package com.exam.service;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dto.CategoryDTO;
import com.exam.exception.CategoryAlreadyExistsException;
import com.exam.exception.CategoryNotFoundException;
import com.exam.entity.Category;
import com.exam.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	
	@Autowired
	private CategoryRepository categoryRepository;
	private static final Logger logger =  LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@Override
	public Category addCategory(CategoryDTO category)throws CategoryAlreadyExistsException{
		Category local=this.categoryRepository.findByTitle(category.getTitle());
		if(local!=null) {
			throw new CategoryAlreadyExistsException();
		}else {
	Category categoryEntity = new Category();
	categoryEntity.setDescription(category.getDescription());
	categoryEntity.setTitle(category.getTitle());
	categoryEntity.setCid(category.getCid());
	Category category2=categoryRepository.save(categoryEntity);
	logger.info("add Category");	
	return categoryEntity ;
		}			
	}

	private Exception CategoryAlreadyExistsException() {
		return null;
	}

	@Override
	public void updateCategory(Long categoryId,String title) throws CategoryNotFoundException{
		if(categoryRepository.existsById(categoryId)) {
			Category category1= categoryRepository.findById(categoryId).get();
			category1.setTitle(title);
			categoryRepository.save(category1);
			logger.info("update Category");
		}else {
		throw new CategoryNotFoundException();
		}
		
	}

	@Override
	public Set<Category> getCategories() {
		logger.info("get AllCategories");
		return  new LinkedHashSet<>(this.categoryRepository.findAll());
	}

 @Override
	public CategoryDTO getCategory(Long cid) throws CategoryNotFoundException{
		java.util.Optional<Category> optional= categoryRepository.findById(cid);
		Category category =  optional.orElseThrow(()-> new CategoryNotFoundException()) ;
		CategoryDTO category2 = new CategoryDTO();
		category2.setCid(category.getCid());
		category2.setTitle(category.getTitle());
		category2.setDescription(category.getDescription());
		logger.info("get Category");
		return category2;
	}

	@Override
	public void deleteCategory(long categoryId) {
		Category category = new Category();
		category.setCid(categoryId);
		this.categoryRepository.delete(category);
		logger.info("delete Category");
	}




}
