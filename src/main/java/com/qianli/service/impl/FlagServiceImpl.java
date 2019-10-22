package com.qianli.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianli.mapper.FlagMapper;
import com.qianli.pojo.Message;
import com.qianli.pojo.Flag;
import com.qianli.pojo.Users;
import com.qianli.service.FlagService;
import com.qianli.service.MyException;

@Service
@Transactional
public class FlagServiceImpl implements  FlagService{
	
	@Autowired
	private  FlagMapper  flagMapper;

	@Override
	public PageInfo<Message> MessageList(Integer pn, Integer pageSize, int uid) {
		 PageHelper.startPage(pn,pageSize);   
		 //startPage后紧跟的这个查询就是分页查询      
		
		 List<Message> Messagelist = flagMapper.AnnunceList(uid);        
		 //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以        
		 PageInfo <Message>pageInfo = new PageInfo<>(Messagelist);        
		 //pageINfo封装了分页的详细信息，也可以指定连续显示的页数

		return pageInfo;
		}





	@Override
	public void updateStatus(Flag flag) throws MyException {
		
		Flag  f=flagMapper.getById(flag.getFid());
		if(f.isStatus())
			throw  new MyException("您已浏览过啦，不用再点啦");
		
		flag.setStatus(true);
		flagMapper.updateStatus(flag);
		
	}


	@Override
	public void delete(Integer fid) {
		flagMapper.delete(fid);
	}


	@Override
	public Flag getById(Integer fid) {
		
		return flagMapper.getById(fid);
	}





	@Override
	public Integer findcount(int userId) {
		return flagMapper.findcount(userId);
	}







}
