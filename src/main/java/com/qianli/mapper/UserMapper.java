package com.qianli.mapper;

import java.util.List;

import com.qianli.pojo.Post;
import com.qianli.pojo.Users;

public interface  UserMapper   {



	Users getById(Integer uid);

	void delete(int uid);

	List<Post> findByPost(int uid);

	List<Users> findByRoot(int root);

	Users getByUsername(String username);

	Users findByCode(String code);

	void save(Users user);

	Users getByMail(String mail);

	List<Users> findAll();

	void updateRoot(Users user);

	void updateInfo(Users u);

	void updatePsw(Users u);

	List<Users> findByUser(Users user);

	List<Users> findMyPost(int uid);


}