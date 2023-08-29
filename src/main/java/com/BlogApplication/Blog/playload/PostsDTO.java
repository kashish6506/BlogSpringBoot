package com.BlogApplication.Blog.playload;

import java.util.List;

import com.SpringBoot.blogApp.Entity.Category;
import com.SpringBoot.blogApp.Entity.Comment;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostsDTO {
long id;
String title;
String description;
String content;
String categoryTitle;
List<Comment> comment;
public List<Comment> getComment() {
	return comment;
}



public void setComment(List<Comment> comment) {
	this.comment = comment;
}

public String getCategoryTitle() {
	return categoryTitle;
}
public void setCategoryTitle(String categoryTitle) {
	this.categoryTitle = categoryTitle;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
@Override
public String toString() {
	return "PostsDTO [id=" + id + ", title=" + title + ", description=" + description + ", content=" + content
			+ ", category=" + categoryTitle + "]";
}



}
