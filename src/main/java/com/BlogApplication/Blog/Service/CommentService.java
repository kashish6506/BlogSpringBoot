package com.BlogApplication.Blog.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringBoot.blogApp.payload.CommentDTO;

@Service
public interface CommentService {

	CommentDTO addCmt(CommentDTO cdto);

	List<CommentDTO> getAllCmt();

	List<CommentDTO> getAllCmtByTitle(int id);

	CommentDTO updateComment(CommentDTO cdto);

	String deleteComment(int id);

}
