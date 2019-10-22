package com.qianli.mapper;

import java.util.List;
import com.qianli.pojo.Image;

public interface ImageMapper {
	Image getById(int iid);
	void save(Image img);
	void update(Image img);
	void delete(int uid);
	List<Image> findAll();
}
