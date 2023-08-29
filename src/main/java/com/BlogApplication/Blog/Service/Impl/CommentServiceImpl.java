package com.BlogApplication.Blog.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.blogApp.Entity.Comment;
import com.SpringBoot.blogApp.Entity.Posts;
import com.SpringBoot.blogApp.Repository.CommentRepository;
import com.SpringBoot.blogApp.Repository.PostRepository;
import com.SpringBoot.blogApp.Service.CommentService;
import com.SpringBoot.blogApp.payload.CommentDTO;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentRepository crepo;
	@Autowired
	PostRepository prepo;
	
	@Override
	public CommentDTO addCmt(CommentDTO cdto) {
		
		Comment cmt = new Comment();
		cmt.setComment(cdto.getComment());
		cmt.setPostid(cdto.getPostid());
		System.out.println(cdto.getPostid());
		Posts post = prepo.findById((long)cdto.getPostid()).get();
		post.getComment().add(cmt); 
		
		prepo.save(post);
		return cdto;
	}

	@Override
	public List<CommentDTO> getAllCmt() {
		List<Comment> cmt = crepo.findAll();
		List<CommentDTO> lcdto = new ArrayList<>();
		for(Comment c : cmt) {
			CommentDTO cdto = new CommentDTO();
			cdto.setCmtid(c.getCmtid());
			cdto.setPostid(c.getPostid());
			cdto.setComment(c.getComment());
			lcdto.add(cdto);
			
		}
		return lcdto;
	}

	

	@Override
	public CommentDTO updateComment(CommentDTO cdto) {
		Comment cmt = new Comment();
		cmt.setCmtid(cdto.getCmtid());
		cmt.setComment(cdto.getComment());
		cmt.setPostid(cdto.getPostid());
		crepo.save(cmt);
		return cdto;
	}

	@Override
	public String deleteComment(int id) {
		Comment c = crepo.findById(id).get();
		Posts p = prepo.findById((long)c.getPostid()).get();
		
		List<Comment> list = p.getComment();
		
		for(Comment cmt:list) {
			if(cmt.getCmtid() == id) {
				list.remove(cmt);
				break;
			}
		}
		p.setComment(list);
		prepo.save(p);
		crepo.deleteById(id);
		return "Deleted SuccessFully";
	}

	@Override
	public List<CommentDTO> getAllCmtByTitle(int id) {
		Posts p = prepo.findById((long)id).get();
		List<Comment> c = p.getComment();
		List<CommentDTO> lcdto = new ArrayList<>();
		for(Comment cmt:c) {
		CommentDTO cdto = new CommentDTO();
		cdto.setCmtid(cmt.getCmtid());
		cdto.setPostid(cmt.getPostid());
		cdto.setComment(cmt.getComment());
		lcdto.add(cdto);
		}
		return lcdto;
	}

}
