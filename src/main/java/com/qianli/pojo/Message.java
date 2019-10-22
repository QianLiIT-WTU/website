package com.qianli.pojo;

import java.util.Date;

import com.google.gson.annotations.Expose;

public class Message { // 公告
	
/*	CREATE TABLE `tb_announce` (
			  `aid` int(11) NOT NULL,
			  `title` varchar(50) NOT NULL,
			  `content` varchar(255) NOT NULL,
			  `create_time` datetime DEFAULT NULL,
			  PRIMARY KEY (`aid`)
			) ENGINE=InnoDB DEFAULT CHARSET=utf8;*/

	@Expose
	private int mid; // id
	@Expose
	private String title; // 标题
	@Expose
	private String content;// 内容
	@Expose
	private String  create_time; // 时间
	@Expose
	private boolean  status;//0可用，1已删除
     
	@Expose
	private String   touser;//-1,null 全部


	


	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}



	



}
