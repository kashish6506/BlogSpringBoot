package com.BlogApplication.Blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.blogApp.Entity.Category;
import com.SpringBoot.blogApp.Entity.Posts;
import com.SpringBoot.blogApp.Service.CategoryService;
import com.SpringBoot.blogApp.payload.CategoryDTO;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	private CategoryService cservice;

	
	
	@GetMapping("getAll")
	public ResponseEntity<List<CategoryDTO>> getAllCategory() {
		return new ResponseEntity<>(cservice.getAllCategory(),HttpStatus.OK);
	}
	
	@GetMapping("get/{name}")
	public ResponseEntity<CategoryDTO> getByName(@PathVariable("name") String name){
		name = name.toLowerCase();
		return new ResponseEntity<CategoryDTO>(cservice.getCategoryByName(name),HttpStatus.OK);
	}
	
	@Transactional
	@DeleteMapping("delete/{cat}")
	public ResponseEntity<String> deleteByName(@PathVariable("cat") String name){
		name = name.toLowerCase();
		return new ResponseEntity<String>(cservice.deleteByName(name),HttpStatus.OK);
	}
	
	
	
}
