package com.ltsk.whcg.entity;

import java.io.Serializable;

public class MostFumeUnit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hotelname;
	private String sum;
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "MostFumeUnit [hotelname=" + hotelname + ", sum=" + sum + "]";
	}
	
}
