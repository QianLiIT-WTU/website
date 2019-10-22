package com.qianli.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.qianli.pojo.BaseDict;
import com.qianli.pojo.Users;

public interface BaseDictService {

	List<BaseDict> findBycode(int dict_type_code);

	PageInfo<BaseDict> selectAll(Integer pn, Integer pageSize, BaseDict basedict);

	void unenable(int  bid);

	
	
	BaseDict findById(int bid);

	void saveOrUpdateItem(BaseDict basedict) throws MyException;

}
