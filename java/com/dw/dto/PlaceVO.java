package com.dw.dto;
import java.util.Set;

public class PlaceVO {
	private String gu;
	private String dong;
	private String gym;
	private String juso;
	private String address;
	private Set<String> dongSet;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJuso() {
		return juso;
	}
	public void setJuso(String juso) {
		this.juso = juso;
	}
	public Set<String> getDongSet() {
		return dongSet;
	}
	public void setDongSet(Set<String> dongSet) {
		this.dongSet = dongSet;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getGym() {
		return gym;
	}
	public void setGym(String gym) {
		this.gym = gym;
	}
	@Override
	public String toString() {
		return "PlaceVO [gu=" + gu + ", dong=" + dong + ", gym=" + gym + "]";
	}
	

}
