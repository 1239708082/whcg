package com.ltsk.whcg.entity;

public class Czjl_excel {
	private String id;
	private String area;
	private String transportunit;
	private String carno;
	private Integer count;
	private Double sum;
	private Double lastsum;
	private Double result;
	private String handleunit;
	
	
	public String getHandleunit() {
		return handleunit;
	}
	public void setHandleunit(String handleunit) {
		this.handleunit = handleunit;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTransportunit() {
		return transportunit;
	}
	public void setTransportunit(String transportunit) {
		this.transportunit = transportunit;
	}
	public String getCarno() {
		return carno;
	}
	public void setCarno(String carno) {
		this.carno = carno;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	public Double getLastsum() {
		return lastsum;
	}
	public void setLastsum(Double lastsum) {
		this.lastsum = lastsum;
	}
	public Double getResult() {
		return result;
	}
	public void setResult(Double result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Czjl_excel [area=" + area + ", transportunit=" + transportunit + ", carno=" + carno + ", count=" + count
				+ ", sum=" + sum + ", lastsum=" + lastsum + ", result=" + result + "]";
	}
	
	
	
}
