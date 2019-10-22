package com.qianli.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Users {
	/*
	 * CREATE TABLE `tb_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) NOT NULL,
  `password` varbinary(50) NOT NULL COMMENT 'MD5加密',
  `mail` varchar(50) NOT NULL,
  `code` varchar(255) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` char(8) DEFAULT NULL,
  `question` varchar(255) NOT NULL COMMENT '找回密码问题',
  `answer` varchar(255) NOT NULL COMMENT '找回密码答案',
  `root` int(4) NOT NULL COMMENT '权限，0未未激活账号，1注册会员，2千里会员，3管理员，4超级管理员',
  `photoaddress` varchar(255) DEFAULT NULL COMMENT '头像地址',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	 * */
	private int uid; //id
	
	private String  username ;//用户名
	private String  password; //密码
	
	private String  question;  
	private String  answer;  
	private boolean sex;    //性别
	private String  mail;  //邮箱
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	private  String  phone;   //电话
	private String  code;//激活码
	private int root; //权限
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setBid(BaseDict bid) {
		this.bid = bid;
	}
	private String  photoaddress; //头像	
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", username=" + username + ", password=" + password + ", question=" + question
				+ ", answer=" + answer + ", sex=" + sex + ", mail=" + mail + ", code=" + code + ", root=" + root
				+ ", photoaddress=" + photoaddress + ", year=" + year + ", postList=" + postList + ", sourceUpList="
				+ sourceUpList + ", sourceDownList=" + sourceDownList + ", bid=" + bid + "]";
	}
	private  String      year; // 加入年限
	
	private List<Post> postList= new ArrayList<Post>();//贴子

	private List<Source> sourceUpList= new ArrayList<Source>();
	private List<Source> sourceDownList= new ArrayList<Source>();
	private BaseDict bid;
	public BaseDict getBid() {
		return bid;
	}
	public void setDict(BaseDict bid) {
		this.bid = bid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	
	
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getRoot() {
		return root;
	}
	public void setRoot(int root) {
		this.root = root;
	}
	public String getPhotoaddress() {
		return photoaddress;
	}
	public void setPhotoaddress(String photoaddress) {
		this.photoaddress = photoaddress;
	}
	public List<Post> getPostList() {
		return postList;
	}
	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}
	public List<Source> getSourceUpList() {
		return sourceUpList;
	}
	public void setSourceUpList(List<Source> sourceUpList) {
		this.sourceUpList = sourceUpList;
	}
	public List<Source> getSourceDownList() {
		return sourceDownList;
	}
	public void setSourceDownList(List<Source> sourceDownList) {
		this.sourceDownList = sourceDownList;
	}
	
	


}
