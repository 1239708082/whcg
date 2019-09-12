package com.ltsk.whcg.entity;

import java.util.Date;

public class ServerStatistics {

	private String servertype;
	private String name;
	private String time;
	private String usertype;
	public String getServertype() {
		return servertype;
	}
	public void setServertype(String servertype) {
		this.servertype = servertype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String date) {
		this.time = date;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	@Override
	public String toString() {
		return "ServerStatistics [servertype=" + servertype + ", name=" + name + ", time=" + time + ", usertype="
				+ usertype + "]";
	}
	
}
