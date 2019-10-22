package com.qianli.pojo;

import java.util.Date;

public class Comment { // 评论
	

	/*
	 * CREATE TABLE `tb_comment` ( `cid` int(11) NOT NULL, `ccid` int(11) DEFAULT
	 * NULL COMMENT '评论本身作为外键', `uid` int(11) DEFAULT NULL COMMENT ' 评论者，外键', `pid`
	 * int(11) DEFAULT NULL COMMENT '帖子，外键', `sid` int(11) DEFAULT NULL COMMENT
	 * '资源，外键', `content` varchar(220) NOT NULL, `create_time` datetime DEFAULT
	 * NULL, PRIMARY KEY (`cid`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	 */
	private Comment ccid;  //评论的评论
	private Users uid;// 评论者
	private Post pid;
	private Source sid;
	private String ccontent; // 内容

	private String  create_time;

	
	private int cid; // id

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Comment getCcid() {
		return ccid;
	}

	public void setCcid(Comment ccid) {
		this.ccid = ccid;
	}

	

	public Users getUid() {
		return uid;
	}

	public void setUid(Users uid) {
		this.uid = uid;
	}

	public Post getPid() {
		return pid;
	}

	public void setPid(Post pid) {
		this.pid = pid;
	}

	public Source getSid() {
		return sid;
	}

	public void setSid(Source sid) {
		this.sid = sid;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public String getCcreate_time() {
		return create_time;
	}

	public void setCcreate_time(String ccreate_time) {
		this.create_time = ccreate_time;
	}

	@Override
	public String toString() {
		return "Comment [ccid=" + ccid + ", uid=" + uid + ", pid=" + pid + ", sid=" + sid + ", ccontent=" + ccontent
				+ ", ccreate_time=" + create_time + ", cid=" + cid + "]";
	}


	

	
	

}
