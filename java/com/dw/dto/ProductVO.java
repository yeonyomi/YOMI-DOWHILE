package com.dw.dto;

import java.util.Date;

/**
 * dowhile의 쇼핑몰 중 상품(PRODUCT)의 정보를 저장하는 VO 클래스
 * 
 * @author limmyoungju
 *
 */
public class ProductVO {
	/* pk */
	private int seq;
	/* 상품명 */
	private String name;
	/* 상품종류 */
	private String kind;
	/* 원가 */
	private int cost;
	/* 판매가 */
	private int price;
	/* 상품내용 */
	private String content;
	private String contentImagePath;

	/* 상품 상세 이미지 경로 */
	private String imagePath;
	/* 상품 썸네일 이미지 경로 */
	private String thumbImagePath;
	/* 상품 삭제 여부 */
	private String useYn;
	/* 베스트 상품 여부 */
	private String bestYn;
	/* 등록일 */
	private Date createDate;
	/* 수정일 */
	private Date updateDate;
	/* 수정자 */
	private String updateBy;
	/* 등록자 */
	private String createBy;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentImagePath() {
		return contentImagePath;
	}

	public void setContentImagePath(String contentImagePath) {
		this.contentImagePath = contentImagePath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getThumbImagePath() {
		return thumbImagePath;
	}

	public void setThumbImagePath(String thumbImagePath) {
		this.thumbImagePath = thumbImagePath;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getBestYn() {
		return bestYn;
	}

	public void setBestYn(String bestYn) {
		this.bestYn = bestYn;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Override
	public String toString() {
		return "ProductVO [seq=" + seq + ", name=" + name + ", kind=" + kind + ", cost=" + cost + ", price=" + price
				+ ", content=" + content + ", imagePath=" + imagePath + ", thumbImagePath=" + thumbImagePath
				+ ", useYn=" + useYn + ", bestYn=" + bestYn + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", updateBy=" + updateBy + ", createBy=" + createBy + ", getSeq()=" + getSeq()
				+ ", getName()=" + getName() + ", getKind()=" + getKind() + ", getCost()=" + getCost() + ", getPrice()="
				+ getPrice() + ", getContent()=" + getContent() + ", getImagePath()=" + getImagePath()
				+ ", getThumbImagePath()=" + getThumbImagePath() + ", getUseYn()=" + getUseYn() + ", getBestYn()="
				+ getBestYn() + ", getCreateDate()=" + getCreateDate() + ", getUpdateDate()=" + getUpdateDate()
				+ ", getUpdateBy()=" + getUpdateBy() + ", getCreateBy()=" + getCreateBy() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
