package com.qianli.pojo;

import java.io.Serializable;
import java.util.List;

public class QueryVo  implements  Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  List<Users>  userlist;

		private int  mid ;
	
	
	
	
	public List<Users> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<Users> userlist) {
		this.userlist = userlist;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
}
