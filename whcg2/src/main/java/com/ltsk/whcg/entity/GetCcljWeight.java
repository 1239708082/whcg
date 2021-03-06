package com.ltsk.whcg.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 餐厨垃圾处理量
 */
public class GetCcljWeight {
	
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String time;
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private Double weight;
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String depname;
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String orgname;
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String times;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return "GetCcljWeight [time=" + time + ", weight=" + weight + ", depname=" + depname + ", orgname=" + orgname
				+ ", times=" + times + "]";
	}

}
