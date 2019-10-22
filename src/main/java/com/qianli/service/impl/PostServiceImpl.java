package com.qianli.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianli.mapper.CommentMapper;
import com.qianli.mapper.PostMapper;
import com.qianli.pojo.BaseDict;
import com.qianli.pojo.Comment;
import com.qianli.pojo.Post;
import com.qianli.pojo.Users;
import com.qianli.service.MyException;
import com.qianli.service.PostService;

@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {
	@Autowired
	private PostMapper postDao;

	@Autowired
	private CommentMapper commentDao;

	public void deletePost(int pid) {
		postDao.delete(pid);

	}

	public void editPost(boolean status, int pid) throws MyException {

		Post post = postDao.findByPid(pid);
		post.setStatus(true);
		postDao.Update(post);

	}

	@Override
	public PageInfo<Post> selectFPost(Integer pn, Integer pageSize, Post post) {
		PageHelper.startPage(pn, pageSize);
		// startPage后紧跟的这个查询就是分页查询

		List<Post> Postlist = postDao.findByFPost(post);
		// 使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
		PageInfo<Post> pageInfo = new PageInfo<>(Postlist);
		// pageINfo封装了分页的详细信息，也可以指定连续显示的页数

		return pageInfo;
	}

	@Override
	public PageInfo<Post> selectTPost(Integer pn, Integer pageSize, Post post) {
		PageHelper.startPage(pn, pageSize);
		// startPage后紧跟的这个查询就是分页查询

		List<Post> Postlist = postDao.findByTPost(post);
		// 使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
		PageInfo<Post> pageInfo = new PageInfo<>(Postlist);
		// pageINfo封装了分页的详细信息，也可以指定连续显示的页数

		return pageInfo;
	}

	@Override
	public void savePost(Post post) {
		postDao.save(post);

	}

	@Override
	public Post findByPid(int pid) {
		Post post = postDao.findByPid(pid);
		List<Comment> comments = commentDao.findByPid(pid);
		post.setCommentList(comments);
		return post;
	}

	@Override
	public void updateStatus(Post post) {
		Post p = postDao.findByPid(post.getPid());

		p.setStatus(post.isStatus());
		postDao.Update(p);

	}

	@Override
	public void update(Post post) {
		Post p = postDao.findByPid(post.getPid());
		p.setTitle(post.getTitle());
		p.setContent(post.getContent());

		p.setBid(post.getBid());
		p.setCreate_time(post.getCreate_time());
		postDao.Update(p);

	}

	@Override
	public void UpdateClick(Post post) {
		Post p = postDao.findByPid(post.getPid());
		p.setClick(post.getClick());
		postDao.UpdateClick(p);

	}

	@Override
	public PageInfo<Post> findMyPost(Integer pn, Integer pageSize, int uid) {
		PageHelper.startPage(pn, pageSize);
		// startPage后紧跟的这个查询就是分页查询

		List<Post> Postlist = postDao.findMyPost(uid);
		// 使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
		PageInfo<Post> pageInfo = new PageInfo<>(Postlist);
		// pageINfo封装了分页的详细信息，也可以指定连续显示的页数

		return pageInfo;
	}

	@Override
	public PageInfo<Post> findHotPost(Integer pn, Integer pageSize) {
		PageHelper.startPage(pn, pageSize);
		// startPage后紧跟的这个查询就是分页查询

		List<Post> Postlist = postDao.findHotPost();
		// 使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
		PageInfo<Post> pageInfo = new PageInfo<>(Postlist);
		// pageINfo封装了分页的详细信息，也可以指定连续显示的页数

		return pageInfo;
	}

}
