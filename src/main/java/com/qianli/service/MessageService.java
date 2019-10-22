package com.qianli.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.qianli.pojo.Message;
import com.qianli.pojo.QueryVo;
import com.qianli.pojo.Users;

public interface MessageService  {

	void save(Message message);

	void relase(QueryVo  vo);

	PageInfo<Message> selectAll(Integer pn, Integer pageSize, Message message);

	void updateStatus(int mid);

	PageInfo<Message> findByUid(Integer pn, Integer pageSize, int uid);

	



	void relaseUser( int uid);
	

}
