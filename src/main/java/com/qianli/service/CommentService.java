package com.qianli.service;

import java.util.List;

import com.qianli.pojo.Comment;
import com.qianli.pojo.Post;

public interface CommentService  {

	void saveComment(Comment comment);

	

	List<Comment> findBypost(Post post);



	List<Comment> findByPid(Integer ppid);



	List<Comment> findBySid(Integer sid);
	
	
}
