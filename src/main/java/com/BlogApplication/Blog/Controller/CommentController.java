package com.BlogApplication.Blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.blogApp.Service.CommentService;
import com.SpringBoot.blogApp.payload.CommentDTO;

@RestController

public class CommentController {

	@Autowired
	CommentService cservice;
	

	public ResponseEntity<CommentDTO> addComment(@RequestBody CommentDTO cdto){
		
		return new ResponseEntity<CommentDTO>(cservice.addCmt(cdto),HttpStatus.CREATED);
	}
	
	@GetMapping("getAllcomments")
public ResponseEntity<List<CommentDTO>> getAll(){
		
		return new ResponseEntity<List<CommentDTO>>(cservice.getAllCmt(),HttpStatus.OK);
	}
	
	
	public ResponseEntity<List<CommentDTO>> getAllByTitle(int id){
			
			return new ResponseEntity<>(cservice.getAllCmtByTitle(id),HttpStatus.OK);
		}
	
	@PutMapping("updateComment")
public ResponseEntity<CommentDTO> updateComment(@RequestBody CommentDTO cdto){
		
		return new ResponseEntity<CommentDTO>(cservice.updateComment(cdto),HttpStatus.OK);
	}
	
			
	@DeleteMapping("delete/{cid}")
	public ResponseEntity<String> deleteComment(@PathVariable ("cid") int id){
			
			return new ResponseEntity<String>(cservice.deleteComment(id),HttpStatus.OK);
		}
}
