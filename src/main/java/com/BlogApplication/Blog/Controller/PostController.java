package com.BlogApplication.Blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.blogApp.Entity.Posts;
import com.SpringBoot.blogApp.Service.PostsService;
import com.SpringBoot.blogApp.payload.CommentDTO;
import com.SpringBoot.blogApp.payload.PostsDTO;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/post")
public class PostController {

	@Autowired
	private PostsService postService;
	
	@PostMapping("createPost")
	public ResponseEntity<PostsDTO> createPost(@RequestBody PostsDTO pdto){
		
		return new ResponseEntity<>(postService.createPost(pdto),HttpStatus.CREATED);
	}
	
	
	@GetMapping("getpost")
	public ResponseEntity<List<PostsDTO>> getPost(){
		return new ResponseEntity<>(postService.getAllPost(),HttpStatus.OK);
	}
	
	@GetMapping("getpost/{pid}")
	public ResponseEntity<PostsDTO> getPostByID(@PathVariable ("pid") int id){
		return new ResponseEntity<>(postService.getAllPostByID(id),HttpStatus.OK);
	}
	
	
	@PutMapping("updatePost")
	public ResponseEntity<PostsDTO> updatePost(@RequestBody PostsDTO p){
		return new ResponseEntity<>(postService.updatePostByID(p),HttpStatus.CREATED);
	}

	
	
	@DeleteMapping("deletePost/{id}")
	public ResponseEntity<String> deletePost(@PathVariable ("id") int id){
		return new ResponseEntity<>(postService.deletePostByID(id),HttpStatus.OK);
	}
	
	// Comment For Each Posts 
		@Autowired
		CommentController cc;
		
		@PostMapping("comment/create")
		public ResponseEntity<CommentDTO> doComment(@RequestBody CommentDTO cmt){
			return cc.addComment(cmt);
		}
		
		@GetMapping("comment/get/{pid}")
		public ResponseEntity<List<CommentDTO>> getComment(@PathVariable("pid") int id){
			return cc.getAllByTitle(id);
		}
		
		@DeleteMapping("comment/delete/{cid}")
		public ResponseEntity<String> deleteComment(@PathVariable("cid") int cid){
			return cc.deleteComment(cid);
		}
	
	
	
	
}
