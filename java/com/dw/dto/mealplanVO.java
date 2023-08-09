package com.dw.dto;

public class mealplanVO {
	private String selectdate,breakfast, breakfastimage, breakfastmemo, lunch, lunchimage, lunchmemo, dinner, dinnerimage,
			dinnermemo;

	public String getSelectdate() {
		return selectdate;
	}

	public void setSelectdate(String selectdate) {
		this.selectdate = selectdate;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	public String getBreakfastimage() {
		return breakfastimage;
	}

	public void setBreakfastimage(String breakfastimage) {
		this.breakfastimage = breakfastimage;
	}

	public String getBreakfastmemo() {
		return breakfastmemo;
	}

	public void setBreakfastmemo(String breakfastmemo) {
		this.breakfastmemo = breakfastmemo;
	}

	public String getLunch() {
		return lunch;
	}

	public void setLunch(String lunch) {
		this.lunch = lunch;
	}

	public String getLunchimage() {
		return lunchimage;
	}

	public void setLunchimage(String lunchimage) {
		this.lunchimage = lunchimage;
	}

	public String getLunchmemo() {
		return lunchmemo;
	}

	public void setLunchmemo(String lunchmemo) {
		this.lunchmemo = lunchmemo;
	}

	public String getDinner() {
		return dinner;
	}

	public void setDinner(String dinner) {
		this.dinner = dinner;
	}

	public String getDinnerimage() {
		return dinnerimage;
	}

	public void setDinnerimage(String dinnerimage) {
		this.dinnerimage = dinnerimage;
	}

	public String getDinnermemo() {
		return dinnermemo;
	}

	public void setDinnermemo(String dinnermemo) {
		this.dinnermemo = dinnermemo;
	}

	@Override
	public String toString() {
		return "mealplanVO [selectdate=" + selectdate + ", breakfast=" + breakfast + ", breakfastimage="
				+ breakfastimage + ", breakfastmemo=" + breakfastmemo + ", lunch=" + lunch + ", lunchimage="
				+ lunchimage + ", lunchmemo=" + lunchmemo + ", dinner=" + dinner + ", dinnerimage=" + dinnerimage
				+ ", dinnermemo=" + dinnermemo + "]";
	}

	
}
