package com.qianli.service;
import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;

import com.github.pagehelper.PageInfo;
import com.qianli.pojo.Post;
import com.qianli.pojo.Users;



public interface UserService {
	//登陆方法
	Users	getUserByUsername(String  username) throws MyException;
	//注册用户
	void saveUser(Users u) throws MyException, MessagingException;
	Users login(Users user)throws MyException;

	Users getUserByUid(int uid)  ;
	List<Users> findByRoot(int root);
	
	List<Post> findByPost(int uid);
	
	void delete(int uid);
	void active(String code) throws MyException;
	
	void updateRoot(Users user) throws MyException;

	Users Alogin(Users user)throws MyException;
	

	void updateInfo(Users user);
	
	void updatePsw(Users user, String password1) throws MyException;
	PageInfo<Users> selectAll(Integer pn, Integer pageSize, Users user);

	List<Users> findAll();
	Users findByUid(int uid);
	void findPsw(Users user) throws MyException;
	Users findUserByname(String username) throws MyException;
	
	
	
	

	
}
