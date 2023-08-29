package com.BlogApplication.Blog.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.blogApp.Entity.Category;
import com.SpringBoot.blogApp.Entity.Posts;
import com.SpringBoot.blogApp.Repository.CategoryRepository;
import com.SpringBoot.blogApp.Repository.PostRepository;
import com.SpringBoot.blogApp.Service.CategoryService;
import com.SpringBoot.blogApp.payload.CategoryDTO;

@Service
public class CategorySrviceImpl implements CategoryService{

	@Autowired
	private CategoryRepository crepo;
	
	
	
	@Override
	public CategoryDTO createCategory(Category cat) {
		Category c = crepo.findByCatname(cat.getCatname());
		
		crepo.save(cat);
		
		CategoryDTO cdto = new CategoryDTO();
		cdto.setId(cat.getId());
		cdto.setCat_name(cat.getCatname());
		cdto.setList(cat.getPosts());
		return cdto;
	}
	
	
	@Override
	public List<CategoryDTO> getAllCategory() {
		List<Category> lcat = crepo.findAll();
		List<CategoryDTO> lcdto = new ArrayList<>();
		for(Category c : lcat) {
			CategoryDTO cdto = new CategoryDTO();
			cdto.setCat_name(c.getCatname());
			cdto.setList(c.getPosts());
			cdto.setId(c.getId());
			lcdto.add(cdto);
		}
		return lcdto;
	}
	@Override
	public CategoryDTO getCategoryByName(String name) {
		Category c = crepo.findByCatname(name);
		CategoryDTO cdto = new CategoryDTO();
		cdto.setCat_name(c.getCatname());
		cdto.setList(c.getPosts());
		cdto.setId(c.getId());
		return cdto;
	}
	@Override
	public String deleteByName(String name) {
		
		//deleting the category 
		crepo.deleteByCatname(name);
		// deleting the posts which related to this post
		
				
		return "Deleted The posts Related To this Category!!";
	}
	

}
