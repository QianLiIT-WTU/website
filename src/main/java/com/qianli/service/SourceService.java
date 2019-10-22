package com.qianli.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.qianli.pojo.Image;
import com.qianli.pojo.Post;
import com.qianli.pojo.Source;

public interface SourceService  {
	void save(Source source) throws MyException;
	Source getSourceById(int sid)  ;
	PageInfo<Source> findAll(Integer pn, Integer pageSize, Source source);
	void delete(int sid);
	void updateStatus(Source source);
	List<Source> getVidList(Source video);
//	PageInfo<Source> findAllToIndex(Integer pn, Integer pageSize, Source source);
	PageInfo<Source> getHotSource(Integer pn, Integer pageSize);


	
}