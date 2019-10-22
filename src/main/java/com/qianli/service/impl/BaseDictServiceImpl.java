package com.qianli.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianli.mapper.BaseDictMapper;
import com.qianli.pojo.BaseDict;

import com.qianli.service.BaseDictService;
import com.qianli.service.MyException;

@Service("basedictService")
@Transactional
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private  BaseDictMapper  basedictMapper;
	
	@Override
	public List<BaseDict> findBycode(int dict_type_code) {
		
		return basedictMapper.findBycode( dict_type_code);
	}
	@Override
	public PageInfo<BaseDict> selectAll(Integer pn, Integer pageSize, BaseDict basedict) {

	
			 PageHelper.startPage(pn,pageSize);   
			 //startPage后紧跟的这个查询就是分页查询      
			
			
			 List<BaseDict> dictlist =basedictMapper.findByDict(basedict);    
		
			 //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以        
			 PageInfo <BaseDict>pageInfo = new PageInfo<>(dictlist);        
			 //pageINfo封装了分页的详细信息，也可以指定连续显示的页数

			return pageInfo;
		}
	
	@Override
	public void unenable(int  bid) {
		
		BaseDict  basedict=basedictMapper.findById(bid);
		
		basedict.setStatus(false);
		
		basedictMapper.updatestatus(basedict);	
		
	}


	@Override
	public BaseDict findById( int bid) {
		
		return  basedictMapper.findById(bid);
	}
	@Override
	public void saveOrUpdateItem(BaseDict basedict) throws MyException {		
		BaseDict  bd=basedictMapper.findByItem(basedict.getDict_item_name());
		if(bd!=null)
			throw new MyException("该名称已存在");
		if (basedict.getBid()==0) {
			basedict.setStatus(true);
			if(basedict.getDict_type_code()==1)
				basedict.setDict_type_name("小组类别");
			if(basedict.getDict_type_code()==2)
				basedict.setDict_type_name("资源类型");
			if(basedict.getDict_type_code()==3)
				basedict.setDict_type_name("帖子类型");			
			basedictMapper.addItem(basedict);
		}
		else {
			
			if(basedict.getDict_type_code()==1)
				basedict.setDict_type_name("小组类别");
			if(basedict.getDict_type_code()==2)
				basedict.setDict_type_name("资源类型");
			if(basedict.getDict_type_code()==3)
				basedict.setDict_type_name("帖子类型");			
			basedictMapper.updateItem(basedict);
		}
		
	}

	}
	


