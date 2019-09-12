package com.ltsk.whcg.entity;

import java.io.Serializable;

//站点情况
public class StationDetail implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String title;
	private Integer num;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "StationDetail [title=" + title + ", num=" + num + "]";
	}
	
	
}
