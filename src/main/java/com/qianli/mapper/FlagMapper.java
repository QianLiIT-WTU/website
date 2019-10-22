package com.qianli.mapper;

import java.util.List;

import com.qianli.pojo.Message;
import com.qianli.pojo.Flag;

public interface FlagMapper {

	List<Message> AnnunceList(int uid);

	

	void delete(Integer fid);



	void updateStatus(Flag flag);



	Flag getById(int fid);



	Integer findcount(int userId);



	





}
