package com.qianli.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianli.mapper.ImageMapper;
import com.qianli.pojo.Image;

import com.qianli.service.ImageService;
import com.qianli.service.MyException;
@Service("imageService")
@Transactional
public class ImageServiceImpl implements ImageService {
	@Autowired
	private  ImageMapper  imageDao;
	
	public void save(Image img) throws MyException{
		imageDao.save(img);
	}
	
	public void update(Image img) throws MyException{
		Image image = imageDao.getById(img.getIid());
		if(!img.getTitle().isEmpty()) {
			image.setTitle(img.getTitle());
		}
		if(!img.getIlink().isEmpty()) {
			image.setIlink(img.getIlink());
		}
		if(img.getStatus()!=image.getStatus()) {
            image.setStatus(img.getStatus());
		}
		if(img.getCreate_time()!=image.getCreate_time()) {
            image.setCreate_time(img.getCreate_time());
		}
        imageDao.update(image);
	}
	
	public void delete(int iid) {
		imageDao.delete(iid);
	}
	
	public List<Image> findAllToJsp(){
		return imageDao.findAll();
	}
	
	public PageInfo<Image> findAll(Integer pn, Integer pageSize, Image img) {
		 PageHelper.startPage(pn,pageSize);   
		 //startPage后紧跟的这个查询就是分页查询      
		 List<Image> imglist =imageDao.findAll();        
		 //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以        
		 PageInfo <Image >pageInfo = new PageInfo<>(imglist);        
		 //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
		 return pageInfo;
	}


}
