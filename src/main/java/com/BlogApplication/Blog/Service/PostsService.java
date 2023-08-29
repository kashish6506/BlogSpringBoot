package com.BlogApplication.Blog.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringBoot.blogApp.Entity.Posts;
import com.SpringBoot.blogApp.payload.PostsDTO;

@Service
public interface PostsService {
	
	public PostsDTO createPost(PostsDTO postDto);

	public List<PostsDTO> getAllPost();

	public PostsDTO getAllPostByID(int id);

	public PostsDTO updatePostByID(PostsDTO p);

	public String deletePostByID(int id);
}
