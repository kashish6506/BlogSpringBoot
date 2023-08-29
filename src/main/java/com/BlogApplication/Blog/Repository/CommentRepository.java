package com.BlogApplication.Blog.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.blogApp.Entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	List<Comment> findByPostid(int postid);

}
