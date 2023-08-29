package com.BlogApplication.Blog.playload;

public class CommentDTO {
int cmtid;
int postid;
String comment;
public int getCmtid() {
	return cmtid;
}
public void setCmtid(int cmtid) {
	this.cmtid = cmtid;
}
public int getPostid() {
	return postid;
}
public void setPostid(int postid) {
	this.postid = postid;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}

}
