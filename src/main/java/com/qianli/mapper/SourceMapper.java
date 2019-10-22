package com.qianli.mapper;

import java.util.List;

import com.qianli.pojo.Source;

public interface SourceMapper {
	void save(Source source);
	Source getSourceById(int sid);
    List<Source> findAll(Source source);
    void delete(int sid);
    void updateStatus(Source source);
	//List<Source> findAllToIndex(Source source);
	List<Source> getHotSource();
}
