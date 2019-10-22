package com.qianli.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Source {
	@Override
	public String toString() {
		return "Source [sid=" + sid + ", uid=" + uid + ", sname=" + sname + ", info=" + info + ", slink=" + slink + ", bid=" + bid + ", create_time=" + create_time + ", status="
				+ status + ", videoImg=" + videoImg + ", click=" + click + ", commentList=" + commentList + "]";
	}

	/*CREATE TABLE `tb_source` (
			  `sid` int(11) NOT NULL,
			  `uid` int(11) DEFAULT NULL COMMENT '发布者，外键',
			  `sname` varchar(50) NOT NULL,
			  `info` varchar(255) DEFAULT NULL COMMENT '简介',
			  `slink` varchar(255) NOT NULL COMMENT '储存地址',
			  `bid` int(11) DEFAULT NULL COMMENT '所属分类 ，外键',
			  `status` bit(1) NOT NULL COMMENT '0,未审核或为通过审核，1通过审核',
			  `click` int(11) NOT NULL COMMENT '下载量',
			  `create_time` datetime DEFAULT NULL,
			  PRIMARY KEY (`sid`)
			) ENGINE=InnoDB DEFAULT CHARSET=utf8;*/
	private int sid ;
	private Users uid;
	private String sname;
	private String info;
	private String slink;
	private BaseDict  bid;
	private String create_time; // 发布时间
	private boolean status ;// 状态，是否审核
	private String videoImg;
	private int click;
	
	private  List<Comment>  commentList=new ArrayList<Comment>();

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public int getSid() {
		return sid;
	}
	
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Users getUid() {
		return uid;
	}
	public void setUid(Users uid) {
		this.uid = uid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getSlink() {
		return slink;
	}
	public void setSlink(String slink) {
		this.slink = slink;
	}
	public BaseDict getBid() {
		return bid;
	}
	public void setBid(BaseDict bid) {
		this.bid = bid;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
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

	public String getVideoImg() {
		return videoImg;
	}

	public void setVideoImg(String videoImg) {
		this.videoImg = videoImg;
	}

	
}
