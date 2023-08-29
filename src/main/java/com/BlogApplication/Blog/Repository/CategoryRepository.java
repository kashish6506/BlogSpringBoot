package com.BlogApplication.Blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.SpringBoot.blogApp.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{


	void deleteByCatname(String name);


	Category findByCatname(String cat);
	

}
