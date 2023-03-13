package com.exam;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedHashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.exam.controller.CategoryController;
import com.exam.dto.CategoryDTO;
import com.exam.entity.Category;
import com.exam.service.CategoryService;


@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

	@InjectMocks
	private CategoryController categoryController;
	
	@Mock
	private CategoryService categoryService;
	
	@Mock
	private Environment environment;
	
	@Test
	public void testAddCategory() throws Exception {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCid(1L);
		categoryDTO.setTitle("Test");
		categoryDTO.setDescription("Test Category");
		
		when(categoryService.addCategory(categoryDTO)).thenReturn(new Category());
		
		ResponseEntity<String> responseEntity = categoryController.addCategory(categoryDTO);
		
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	}
	
	@Test
	public void testGetCategory() throws Exception {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCid(1L);
		categoryDTO.setTitle("Test");
		categoryDTO.setDescription("Test Category");
		
		when(categoryService.getCategory(1L)).thenReturn(categoryDTO);
		
		CategoryDTO responseDTO = categoryController.getCategory(1L);
		
		assertEquals("Test", responseDTO.getTitle());
	}
	
	@Test
	public void testGetCategories() throws Exception {
		when(categoryService.getCategories()).thenReturn(new LinkedHashSet<Category>());
		
		ResponseEntity<?> responseEntity = categoryController.getCategories();
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void testUpdateCategory() throws Exception {
		//when(categoryService.updateCategory(anyLong(), toString())).thenReturn(new Category());
		
		ResponseEntity<String> responseEntity = categoryController.updateCategory(1L, new CategoryDTO());
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void testDeleteCategory() throws Exception {
		doNothing().when(categoryService).deleteCategory(anyLong());
		
		categoryController.deleteCategory(1L);
		
		verify(categoryService, times(1)).deleteCategory(1L);
	}
}
