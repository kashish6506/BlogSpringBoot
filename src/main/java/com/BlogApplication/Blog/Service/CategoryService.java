package com.BlogApplication.Blog.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringBoot.blogApp.Entity.Category;
import com.SpringBoot.blogApp.Entity.Posts;
import com.SpringBoot.blogApp.payload.CategoryDTO;

@Service
public interface CategoryService {

	CategoryDTO createCategory(Category cat);

	List<CategoryDTO> getAllCategory();

	CategoryDTO getCategoryByName(String name);

	String deleteByName(String name);


	

}
