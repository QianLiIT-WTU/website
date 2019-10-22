package com.qianli.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qianli.mapper.CommentMapper;
import com.qianli.pojo.Comment;
import com.qianli.pojo.Post;
import com.qianli.service.CommentService;

@Service("commentService")
@Transactional
public class CommentServiveImpl implements CommentService {
	@Autowired
	  private  CommentMapper  commentDao;

	@Override
	public void saveComment(Comment comment) {
		commentDao.saveComment(comment);
		
	}

	
	@Override
	public List<Comment> findBypost(Post post) {
		return commentDao.findByPost( post);
	}


	

	@Override
	public List<Comment> findByPid(Integer pid) {
		return commentDao.findByPid(pid);
	}


	@Override
	public List<Comment> findBySid(Integer sid) {
		// TODO Auto-generated method stub
		return commentDao.findBySid(sid);
	}
}
