package com.qianli.pojo;

import com.sun.mail.imap.protocol.Status;

public class Flag {
	
	private  int  fid;
	private  Users uid;
	private  Message  mid;
	private  boolean status ;
	private  String  readtime;
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public Users getUid() {
		return uid;
	}
	public void setUid(Users uid) {
		this.uid = uid;
	}

	public Message getMid() {
		return mid;
	}
	public void setMid(Message mid) {
		this.mid = mid;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getReadtime() {
		return readtime;
	}
	public void setReadtime(String readtime) {
		this.readtime = readtime;
	}
	@Override
	public String toString() {
		return "Flag [fid=" + fid + ", uid=" + uid + ", mid=" + mid + ", status=" + status + ", readtime=" + readtime
				+ "]";
	}

  }
