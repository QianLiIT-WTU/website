package com.qianli.pojo;

public class BaseDict {
	@Override
	public String toString() {
		return "BaseDict [bid=" + bid + ", dict_type_code=" + dict_type_code + ", dict_type_name=" + dict_type_name
				+ ", dict_item_name=" + dict_item_name + ", status=" + status + "]";
	}
	/*CREATE TABLE `base_dict` (
			  `bid` int(11) NOT NULL AUTO_INCREMENT,
			  `dict_type_code` int(11) NOT NULL,
			  `dict_type_name` varchar(50) NOT NULL,
			  `dict_item_name` varchar(50) DEFAULT NULL,
			  `status` bit(1) NOT NULL COMMENT '0不可用，1可用',
			  PRIMARY KEY (`bid`)
			) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	*/
	private  int bid;
	private  int dict_type_code;
	private String  dict_type_name;
	private String  dict_item_name;
	private  boolean status;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getDict_type_code() {
		return dict_type_code;
	}
	public void setDict_type_code(int dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
	public String getDict_type_name() {
		return dict_type_name;
	}
	public void setDict_type_name(String dict_type_name) {
		this.dict_type_name = dict_type_name;
	}
	public String getDict_item_name() {
		return dict_item_name;
	}
	public void setDict_item_name(String dict_item_name) {
		this.dict_item_name = dict_item_name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
