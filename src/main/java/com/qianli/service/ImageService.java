package com.qianli.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.qianli.pojo.Image;

public interface ImageService  {
	void save(Image img) throws MyException;
	void update(Image img) throws MyException;
	void delete(int iid);
	List<Image> findAllToJsp();
	PageInfo<Image> findAll(Integer pn, Integer pageSize, Image img);
}
