package com.dw.dto;

import java.sql.Date;

public class CartVO {

	
	private String id;//아이디
	private int pSeq;//상품번호
	private String imagePath;//상품이미지
	private String name;
	private int quantity;//주문수량
	private int price;//가격
	private Date creatDate;//등록일
	private Date upDate;//수정일

	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getpSeq() {
		return pSeq;
	}
	public void setpSeq(int pSeq) {
		this.pSeq = pSeq;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	public Date getUpDate() {
		return upDate;
	}
	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}


}
