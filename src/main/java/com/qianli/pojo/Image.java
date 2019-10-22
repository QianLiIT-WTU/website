package com.qianli.pojo;

import java.util.Date;

public class Image { //幻灯片管理
	
/*	CREATE TABLE `tb_image` (
			  `iid` int(11) NOT NULL,
			  `title` varchar(50) NOT NULL,
			  `ilink` varchar(255) NOT NULL,
			  `create_time` datetime DEFAULT NULL,
			  `status` int(4) DEFAULT NULL,
			  PRIMARY KEY (`iid`)
			) ENGINE=InnoDB DEFAULT CHARSET=utf8;*/
	
	 private  int  iid; //id
	   private String title; //名称
	   private  String  ilink;//储存路径
	   private  String create_time ; //上传时间
	   private  int status ; //状态
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIlink() {
		return ilink;
	}
	public void setIlink(String ilink) {
		this.ilink = ilink;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}


	
	   
}
