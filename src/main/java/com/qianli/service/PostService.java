package com.qianli.service;

import com.github.pagehelper.PageInfo;
import com.qianli.pojo.BaseDict;
import com.qianli.pojo.Post;

public interface PostService  {

	

	

	

	void deletePost(int  pid);

	

	void editPost(boolean state,int pid) throws MyException;



	PageInfo<Post> selectFPost(Integer pn, Integer pageSize, Post post);

	PageInfo<Post> selectTPost(Integer pn, Integer pageSize, Post post);



	void savePost(Post post);



	Post findByPid(int pid);



	



	void updateStatus(Post post);



	void UpdateClick(Post post);



	PageInfo<Post> findMyPost(Integer pn, Integer pageSize, int uid);



	void update(Post post);



	PageInfo<Post> findHotPost(Integer pn, Integer pageSize);

	
	
	
}
