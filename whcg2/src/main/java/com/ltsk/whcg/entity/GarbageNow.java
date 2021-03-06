package com.ltsk.whcg.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

//实时生活垃圾
public class GarbageNow {
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String xzqh ;
	private String weigh;
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String time ;
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String wetWeigh;
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String totalWeigh;
	
	public String getWetWeigh() {
		return wetWeigh;
	}


	public void setWetWeigh(String wetWeigh) {
		this.wetWeigh = wetWeigh;
	}


	public String getTotalWeigh() {
		return totalWeigh;
	}


	public void setTotalWeigh(String totalWeigh) {
		this.totalWeigh = totalWeigh;
	}


	public String getXzqh() {
		return xzqh;
	}


	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}


	public String getWeigh() {
		return weigh;
	}


	public void setWeigh(String weigh) {
		this.weigh = weigh;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "GarbageNow [xzqh=" + xzqh + ", weigh=" + weigh + ", time=" + time + ", wetWeigh=" + wetWeigh
				+ ", totalWeigh=" + totalWeigh + "]";
	}


	
	
	
}
