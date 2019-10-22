package com.qianli.mapper;

import java.util.List;

import com.qianli.pojo.Comment;
import com.qianli.pojo.Post;

public interface CommentMapper {

	void saveComment(Comment comment);

	

	List<Comment> findByPost(Post post);



	List<Comment> findByPid(Integer pid);



	List<Comment> findBySid(Integer sid);
	

}
