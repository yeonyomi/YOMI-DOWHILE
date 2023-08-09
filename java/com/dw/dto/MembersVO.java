package com.dw.dto;

import java.util.Date;


public class MembersVO {
	private int num;
	private String id,pass,name,address,phone,lev;
	private Date joindate;
	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public String getLev() {
		return lev;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	@Override
	public String toString() {
		return "MembersVO [num=" + num + ", id=" + id + ", pass=" + pass + ", name=" + name + ", address=" + address
				+ ", phone=" + phone + ", lev=" + lev + ", joindate=" + joindate + "]";
	}
	
	
	
}
