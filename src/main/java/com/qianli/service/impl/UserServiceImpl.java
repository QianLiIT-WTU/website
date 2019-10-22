package com.qianli.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianli.mapper.UserMapper;
import com.qianli.pojo.Post;
import com.qianli.pojo.Users;
import com.qianli.service.MyException;
import com.qianli.service.UserService;
import com.voiweb.utils.mail.VoiMail;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userDao ;

	@Override
	public Users getUserByUsername(String username) throws MyException {
		return userDao.getByUsername(username);
	}

	@Override
	public void saveUser(Users user) throws MyException, MessagingException {
		Users u = userDao.getByUsername(user.getUsername());
		
		if (u != null)
			throw new MyException("该用户名已注册");
		Users u2 = userDao.getByMail(user.getMail());
		if (u2 != null)
			throw new MyException("该邮箱已注册");
		
		user.setCode(UUID.randomUUID().toString());
		sentMail(user.getMail(), user.getCode());
		//md5密码加密
		String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Password);
		userDao.save(user);
       
	}
	public void sentMail(String mail, String code) throws MessagingException {
		VoiMail.config(VoiMail.SMTP_QQ(true), "3181464426@qq.com", "wwpbzhaapkptdeab");

		VoiMail.subject("账号激活").from("	千里IT").to(mail)
				.html("<div align='center'><a href='http://118.89.164.185:8080/website/user/active?code=" + code
						+ "'><img src='http://118.89.164.185:8080/website/img/qianli.jpg' /></a>"
						+ "<h2>点击图片进行激活</h2></div>")
				.send();

	}
	
	@Override
	public void active(String code) throws MyException {
		Users user = userDao.findByCode(code);
		if (user == null)
			throw new MyException("激活码无效");
		if (user.getRoot() > 1)
			throw new MyException("您已经激活了，不可重复激活");
		user.setRoot(2);
		userDao.updateRoot(user);

	}

	@Override
	public Users login(Users user) throws MyException {

		Users u = userDao.getByUsername(user.getUsername());
		//md5密码加密
				String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
				user.setPassword(md5Password);

		if (u == null) {
			throw new MyException("用户名错误");
		}
		if (!user.getPassword().equals(u.getPassword())) {

			throw new MyException("密码错误");

		}
		return u;

	}

	@Override
	public Users Alogin(Users user) throws MyException {
		Users u = userDao.getByUsername(user.getUsername());
		//md5密码加密
		String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Password);

		if (u == null) {
			throw new MyException("用户名错误");
		}
		if (!user.getPassword().equals(u.getPassword())) {
			throw new MyException("密码错误");
		}
		if (u.getRoot() <= 3) {
			throw new MyException("您不是管理员");
		}

		return u;
	}


	@Override
	public Users getUserByUid(int uid) {

		return userDao.getById(uid);
	}

	@Override
	public List<Users> findByRoot(int root) {

		return userDao.findByRoot(root);
	}

	public void updateRoot(Users user) throws MyException {
		Users u = userDao.getById(user.getUid());
		if (u.getRoot() == 1)
			throw new MyException("该账号未激活，不能进行操作");

		u.setRoot(user.getRoot());
		userDao.updateRoot(u);

	}

	@Override
	public List<Post> findByPost(int uid) {

		return userDao.findByPost(uid);
	}

	@Override
	public void delete(int uid) {
		userDao.delete(uid);

	}

	
	public void updateInfo(Users user) {
		Users u = userDao.getById(user.getUid());
		String address=user.getPhotoaddress();
		if (user.getPhone()!=u.getPhone())
			u.setPhone(user.getPhone());
		if (!address.isEmpty()) 
			
		   u.setPhotoaddress(address);
		
		
		userDao.updateInfo(u);

	}

	public void updatePsw(Users user, String password1) throws MyException {
		Users u = userDao.getById(user.getUid());
		//md5密码加密
		
		String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Password);
		if (!u.getPassword().equals(user.getPassword())) {
			throw new MyException("原密码错误");
		}

		u.setPassword(password1);
		userDao.updatePsw(u);

	}


	@Override
	public PageInfo<Users> selectAll(Integer pn, Integer pageSize,Users user) {
		 PageHelper.startPage(pn,pageSize);   
		 //startPage后紧跟的这个查询就是分页查询      
		
		 List<Users> userlist =userDao.findByUser(user);        
		 //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以        
		 PageInfo <Users >pageInfo = new PageInfo<>(userlist);        
		 //pageINfo封装了分页的详细信息，也可以指定连续显示的页数

		return pageInfo;
	}

	

	@Override
	public List<Users> findAll() {
		
		return userDao.findAll();
	}

	@Override
	public Users findByUid(int uid) {
		return userDao.getById(uid);
	}

	@Override
	public void findPsw(Users user) throws MyException {
		Users  u=userDao.getByUsername(user.getUsername());
		
		if  (u==null)
			throw  new MyException("该用户不存在");
		if(!u.getAnswer().equals(user.getAnswer()))
			throw  new MyException("答案错误");
		String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Password);
		u.setPassword(user.getPassword());
		userDao.updatePsw(u);
	}

	@Override
	public Users findUserByname(String username) throws MyException {
		Users  u=userDao.getByUsername(username);
		if  (u==null)
			throw  new MyException("该用户不存在");
		return userDao.getByUsername(username);
		
	}







	

}
