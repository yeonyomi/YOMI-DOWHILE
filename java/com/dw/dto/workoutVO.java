package com.dw.dto;

public class workoutVO {
	private String selectdate, exercise, time, part, content1, content2, content3, content4, content5;

	public String getSelectdate() {
		return selectdate;
	}

	public void setSelectdate(String selectdate) {
		this.selectdate = selectdate;
	}

	public String getExercise() {
		return exercise;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public String getContent3() {
		return content3;
	}

	public void setContent3(String content3) {
		this.content3 = content3;
	}

	public String getContent4() {
		return content4;
	}

	public void setContent4(String content4) {
		this.content4 = content4;
	}

	public String getContent5() {
		return content5;
	}

	public void setContent5(String content5) {
		this.content5 = content5;
	}

	@Override
	public String toString() {
		return "workoutVO [selectdate=" + selectdate + ", exercise=" + exercise + ", time=" + time + ", part=" + part
				+ ", content1=" + content1 + ", content2=" + content2 + ", content3=" + content3 + ", content4="
				+ content4 + ", content5=" + content5 + "]";
	}

	

}
