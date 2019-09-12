package com.ltsk.whcg.entity;

import java.io.Serializable;

public class WarningArea implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String time;
	private String num;
	@Override
	public String toString() {
		return "WarningArea [time=" + time + ", num=" + num + "]";
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	
}
