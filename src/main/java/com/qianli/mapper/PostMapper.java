package com.qianli.mapper;

import java.util.List;

import com.qianli.pojo.Post;

public interface PostMapper {

	

	

	

	void save(Post post);

	List<Post> findByFPost(Post post);
	
	List<Post> findByTPost(Post post);

	void delete(int pid);





	void Update(Post post);





	Post findByPid(int pid);

	List<Post> findMyPost(int uid);

	void UpdateClick(Post p);

	List<Post> findHotPost();
	

}
