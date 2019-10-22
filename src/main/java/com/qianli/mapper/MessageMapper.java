package com.qianli.mapper;

import java.util.List;

import com.qianli.pojo.Message;
import com.qianli.pojo.QueryVo;
import com.qianli.pojo.Users;


public interface MessageMapper  {

	void save(Message message);

	void relase(QueryVo vo);

	List<Message> find(Message message);

	

	Message getById(int mid);

	void update(Message message);

	List<Message> findByUid(int uid);

	void relaseUser(int uid);
	

}
