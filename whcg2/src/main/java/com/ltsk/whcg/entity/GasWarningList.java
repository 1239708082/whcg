package com.ltsk.whcg.entity;

import java.io.Serializable;
//燃气各区告警数据
public class GasWarningList  extends Object implements Serializable{

	private static final long serialVersionUID = 1L;

	private String xzqh;//区域
	
	private String todayDate;//今日警告指数
	
	private String yesterdayDate;//昨日警告指数

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public String getTodayDate() {
		return todayDate;
	}

	public void setTodayDate(String todayDate) {
		this.todayDate = todayDate;
	}

	public String getYesterdayDate() {
		return yesterdayDate;
	}

	public void setYesterdayDate(String yesterdayDate) {
		this.yesterdayDate = yesterdayDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "GasWarningList [xzqh=" + xzqh + ", todayDate=" + todayDate + ", yesterdayDate=" + yesterdayDate + "]";
	}
	
	
	
	
	
}
