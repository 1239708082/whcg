package com.ltsk.whcg.entity;

public class LastWeekSHLJ {

	private String day;//当前星期几
	
	private String handleunit;//处理厂
	
	private String netweight;//处理吨数

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getHandleunit() {
		return handleunit;
	}

	public void setHandleunit(String handleunit) {
		this.handleunit = handleunit;
	}

	public String getNetweight() {
		return netweight;
	}

	public void setNetweight(String netweight) {
		this.netweight = netweight;
	}

	@Override
	public String toString() {
		return "LastWeekSHLJ [day=" + day + ", handleunit=" + handleunit + ", netweight=" + netweight + "]";
	}
	
	
	
}
