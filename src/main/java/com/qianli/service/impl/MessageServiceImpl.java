package com.qianli.service.impl;





import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.qianli.mapper.MessageMapper;
import com.qianli.mapper.UserMapper;
import com.qianli.pojo.Message;
import com.qianli.pojo.QueryVo;
import com.qianli.pojo.Users;
import com.qianli.service.MessageService;

@Service("announceService")
@Transactional
public class MessageServiceImpl implements MessageService {
	
	@Autowired
   private  MessageMapper  messageDao ;
	@Autowired
	   private  UserMapper  userDao ;

	@Override
	public void save(Message message) {
		messageDao.save(message);
		Users user = userDao.getById(Integer.parseInt(message.getTouser()));
		List<Users> uList = new ArrayList<>();
		uList.add(user);
		
		QueryVo vo = new QueryVo();
		vo.setUserlist(uList);
		vo.setMid(message.getMid());
		System.out.println(vo.toString());
		messageDao.relase(vo);
		
		
	
		
	}

	@Override
	public void relase(QueryVo  vo) {
		messageDao.relase(vo);
		
	}

	@Override
	public PageInfo<Message> selectAll(Integer pn, Integer pageSize, Message message) {
		 PageHelper.startPage(pn,pageSize);   
		 //startPage后紧跟的这个查询就是分页查询      
		
		 List<Message> Messagelist =messageDao.find( message);        
		 //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以        
		 PageInfo <Message >pageInfo = new PageInfo<>(Messagelist);        
		 //pageINfo封装了分页的详细信息，也可以指定连续显示的页数

		return pageInfo;
	}

	@Override
	public void updateStatus(int aid) {
	  
		Message  announce=messageDao.getById(aid);
		announce.setStatus(true);
		messageDao.update(announce);
		
	}

	@Override
	public PageInfo<Message> findByUid(Integer pn, Integer pageSize, int uid) {
		 PageHelper.startPage(pn,pageSize);   
		 //startPage后紧跟的这个查询就是分页查询      
		
		 List<Message> Messagelist =messageDao.findByUid( uid);        
		 //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以        
		 PageInfo <Message >pageInfo = new PageInfo<>(Messagelist);        
		 //pageINfo封装了分页的详细信息，也可以指定连续显示的页数

		return pageInfo;
	}

	@Override
	public void relaseUser(int uid) {
		
		messageDao.relaseUser(uid);
		
	}
	
	
	

}
