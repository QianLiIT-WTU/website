package com.qianli.service;

import com.github.pagehelper.PageInfo;
import com.qianli.pojo.Message;
import com.qianli.pojo.Flag;
import com.qianli.pojo.Users;

public interface FlagService {

	PageInfo<Message> MessageList(Integer pn, Integer pageSize, int uid);

	

	void delete(Integer fid);



	void updateStatus(Flag flag) throws MyException;



	Flag getById(Integer fid);



	Integer findcount(int userId);

}
