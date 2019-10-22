package com.qianli.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Post { // 贴子
	
/*	CREATE TABLE `tb_post` (
			  `pid` int(11) NOT NULL AUTO_INCREMENT,
			  `uid` int(11) NOT NULL COMMENT '作者,外键',
			  `title` varchar(50) NOT NULL,
			  `content` varchar(255) NOT NULL,
			  `bid` int(11) NOT NULL COMMENT '所属分类，外键',
			  `click` int(11) NOT NULL COMMENT '点击量',
			  `status` bit(1) NOT NULL COMMENT '状态，0未审核或未通过审核，1已审核',
			  `create_time` datetime DEFAULT NULL,
			  PRIMARY KEY (`pid`)
			) ENGINE=InnoDB DEFAULT CHARSET=utf8;*/
	
	private int pid; // id
	private Users uid;// 作者
	private String title; // 标题
	private String content; // 内容
	private BaseDict bid;
	
	private String create_time; // 发布时间
	private boolean status ;// 状态，是否审核
	private int click;

	private  List<Comment>  commentList=new ArrayList<Comment>();

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public Users getUid() {
		return uid;
	}
	public void setBid(BaseDict bid) {
		this.bid = bid;
	}
	public void setUid(Users uid) {
		this.uid = uid;
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
	public BaseDict getBid() {
		return bid;
	}
	public void setDict(BaseDict bid) {
		this.bid = bid;
	}

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	@Override
	public String toString() {
		return "Post [pid=" + pid + ", uid=" + uid + ", title=" + title + ", content=" + content + ", bid=" + bid
				+ ", create_time=" + create_time + ", status=" + status + ", click=" + click + ", commentList="
				+ commentList + "]";
	}
	
	

	
}
