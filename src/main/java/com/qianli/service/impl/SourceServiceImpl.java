package com.qianli.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianli.mapper.CommentMapper;
import com.qianli.mapper.SourceMapper;
import com.qianli.pojo.Comment;
import com.qianli.pojo.Source;
import com.qianli.service.MyException;
import com.qianli.service.SourceService;

@Service("sourceService")
@Transactional
public class SourceServiceImpl implements SourceService {
	@Autowired
	private SourceMapper soureceDao;
	@Autowired
    private  CommentMapper   commentDao;

	public void save(Source source) throws MyException{
		soureceDao.save(source);
	}

	@Override
	public Source getSourceById(int sid)   {
		Source source=soureceDao.getSourceById(sid);
		List<Comment>  comments=commentDao.findBySid(sid);
		source.setCommentList(comments);
		return  source;
	}
	
	public PageInfo<Source> findAll(Integer pn, Integer pageSize, Source source){
		PageHelper.startPage(pn,pageSize);   
		 //startPage后紧跟的这个查询就是分页查询      
		 List<Source> picList = soureceDao.findAll(source);
		 //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以        
		 PageInfo<Source> pageInfo = new PageInfo<>(picList);        
		 //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
		 return pageInfo;
	}
	
	public void delete(int sid) {
		soureceDao.delete(sid);
	}
	
	public void updateStatus(Source source) {
		soureceDao.updateStatus(source);
	}
	
	public List<Source> getVidList(Source video){
		return soureceDao.findAll(video);
	}

	
	public PageInfo<Source> getHotSource(Integer pn, Integer pageSize) {
		PageHelper.startPage(pn,pageSize);   
		 //startPage后紧跟的这个查询就是分页查询      


			 List<Source> picList = soureceDao.getHotSource();
			
			 //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以        
			 PageInfo<Source> pageInfo = new PageInfo<>(picList);        
			 //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
			 return pageInfo;
		
		
	}
}
