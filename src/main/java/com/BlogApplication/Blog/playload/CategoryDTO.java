package com.BlogApplication.Blog.playload;

import java.util.List;

import com.SpringBoot.blogApp.Entity.Posts;

public class CategoryDTO {
	private int id;
	private String cat_name;
	private List<Posts> list;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public List<Posts> getList() {
		return list;
	}
	public void setList(List<Posts> list) {
		this.list = list;
	}
	
	

}
