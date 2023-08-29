package com.BlogApplication.Blog.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.blogApp.Entity.Category;
import com.SpringBoot.blogApp.Entity.Posts;
import com.SpringBoot.blogApp.Repository.CategoryRepository;
import com.SpringBoot.blogApp.Repository.PostRepository;
import com.SpringBoot.blogApp.Service.PostsService;
import com.SpringBoot.blogApp.controller.CategoryController;
import com.SpringBoot.blogApp.payload.PostsDTO;

@Service
public class PostsServiceImpl implements PostsService{

	@Autowired
	private PostRepository prepo;
	@Autowired
	private CategoryRepository crepo;
	
	
	@Override
	public PostsDTO createPost(PostsDTO postDto) {
		Posts post = new Posts();
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());
		//checking whether the category is present or not
		Category c = crepo.findByCatname(postDto.getCategoryTitle());
		// if category is present then update the post in the category 
		if(c!=null) {
			List<Posts> l = c.getPosts();
			l.add(post);
			c.setPosts(l);
		}
		else {
			// if not present we will create the Category and update it with the post 
			   c = new Category();
			   List<Posts> list = new ArrayList<>();
			   list.add(post);
			   c.setCatname(postDto.getCategoryTitle());
			   c.setPosts(list);
		}
		System.out.println(c);
		//setting the Category of the post
		post.setCategoryTitle(postDto.getCategoryTitle());
		// Setting empty Comment list
		post.setComment(postDto.getComment());
		
		// saving the category and this will automatically update post (one-many)
		crepo.save(c);
		
		
		
		//converting Posts to PostDto
		PostsDTO pdto = new PostsDTO();
		pdto.setId(post.getId());
		pdto.setTitle(post.getTitle());
		pdto.setContent(post.getContent());
		pdto.setDescription(post.getDescription());
		pdto.setCategoryTitle(post.getCategoryTitle());
		pdto.setComment(post.getComment());
		return pdto;
	}


	@Override
	public List<PostsDTO> getAllPost() {
		List<Posts> list = prepo.findAll();
		List<PostsDTO> ldto = new ArrayList<>();
		for(Posts p:list) {
			PostsDTO pdto = new PostsDTO();
			pdto.setId(p.getId());
			pdto.setTitle(p.getTitle());	
			pdto.setContent(p.getContent());
			pdto.setDescription(p.getDescription());
			pdto.setComment(p.getComment());
			pdto.setCategoryTitle(p.getCategoryTitle());
			ldto.add(pdto);
		}
		return ldto;
	}


	@Override
	public PostsDTO getAllPostByID(int id) {
		Posts p = prepo.findById((long) id).get();
		PostsDTO pdto = new PostsDTO();
		pdto.setId(p.getId());
		pdto.setTitle(p.getTitle());
		pdto.setContent(p.getContent());
		pdto.setDescription(p.getDescription());
		pdto.setCategoryTitle(p.getCategoryTitle());
		pdto.setComment(p.getComment());
		return pdto;
	}


	@Override
	public PostsDTO updatePostByID(PostsDTO p) {
		Posts po = new Posts();
		po.setId(p.getId());
		po.setTitle(p.getTitle());
		po.setDescription(p.getDescription());
		po.setContent(p.getContent());
		prepo.save(po);
		return p;
	}


	@Override
	public String deletePostByID(int id) {
		
		
		Posts post = prepo.findById((long)id).get();
		
		Category c = crepo.findByCatname(post.getCategoryTitle());
		System.out.println(c);
		List<Posts> lp = c.getPosts();
		
		for(Posts p :lp) {
			System.out.println(p.getId()+" "+id);
			if(p.getId() == (long)id) {
				lp.remove(prepo.findById((long)id).get());
				System.out.println(prepo.findById((long)id).get().toString());
				break;
			}
		}
		c.setPosts(lp);
		crepo.save(c);
		prepo.deleteById((long)id);
		
		
		return "Deleted Sucessfully";
	}
	
	

}
