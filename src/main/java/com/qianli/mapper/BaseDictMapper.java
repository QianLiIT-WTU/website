package com.qianli.mapper;

import java.util.List;

import com.qianli.pojo.BaseDict;

public interface BaseDictMapper {

	List<BaseDict> findBycode(int dict_type_code);

	List<BaseDict> findByDict(BaseDict basedict);

	BaseDict findById(int bid);

	void updatestatus(BaseDict basedict);

	void addItem(BaseDict basedict);

	void updateItem(BaseDict bd);

	BaseDict findByItem(String dict_item_name);

}
