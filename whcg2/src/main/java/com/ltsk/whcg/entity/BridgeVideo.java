package com.ltsk.whcg.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

//桥梁坐标及视频信息
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class BridgeVideo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String gdxy; 
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String keyid;
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String areaid;
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String bridgeid;
	private String bridgename;
	private String bridgexlongitude;
	private String bridgeylatitude;
	private String pointcode;
	private String coordinate;
	private String videoname;
	private String ip;
	private String port;
	private String guid;
	private String loginname;
	private String password;
	private String imgurl;
	private String visible;
	private String pointid;
	private String createdtime;
	private String http;
	private String gdx;
	private String gdy ;
	@Override
	public String toString() {
		return "BridgeVideo [gdxy=" + gdxy + ", keyid=" + keyid + ", areaid=" + areaid + ", bridgeid=" + bridgeid
				+ ", bridgename=" + bridgename + ", bridgexlongitude=" + bridgexlongitude + ", bridgeylatitude="
				+ bridgeylatitude + ", pointcode=" + pointcode + ", coordinate=" + coordinate + ", videoname="
				+ videoname + ", ip=" + ip + ", port=" + port + ", guid=" + guid + ", loginname=" + loginname
				+ ", password=" + password + ", imgurl=" + imgurl + ", visible=" + visible + ", pointid=" + pointid
				+ ", createdtime=" + createdtime + ", http=" + http + ", gdx=" + gdx + ", gdy=" + gdy + "]";
	}
	public String getGdxy() {
		return gdxy;
	}
	public void setGdxy(String gdxy) {
		this.gdxy = gdxy;
	}
	public String getKeyid() {
		return keyid;
	}
	public void setKeyid(String keyid) {
		this.keyid = keyid;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public String getBridgeid() {
		return bridgeid;
	}
	public void setBridgeid(String bridgeid) {
		this.bridgeid = bridgeid;
	}
	public String getBridgename() {
		return bridgename;
	}
	public void setBridgename(String bridgename) {
		this.bridgename = bridgename;
	}
	public String getBridgexlongitude() {
		return bridgexlongitude;
	}
	public void setBridgexlongitude(String bridgexlongitude) {
		this.bridgexlongitude = bridgexlongitude;
	}
	public String getBridgeylatitude() {
		return bridgeylatitude;
	}
	public void setBridgeylatitude(String bridgeylatitude) {
		this.bridgeylatitude = bridgeylatitude;
	}
	public String getPointcode() {
		return pointcode;
	}
	public void setPointcode(String pointcode) {
		this.pointcode = pointcode;
	}
	public String getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}
	public String getVideoname() {
		return videoname;
	}
	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getVisible() {
		return visible;
	}
	public void setVisible(String visible) {
		this.visible = visible;
	}
	public String getPointid() {
		return pointid;
	}
	public void setPointid(String pointid) {
		this.pointid = pointid;
	}
	public String getCreatedtime() {
		return createdtime;
	}
	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}
	public String getHttp() {
		return http;
	}
	public void setHttp(String http) {
		this.http = http;
	}
	public String getGdx() {
		return gdx;
	}
	public void setGdx(String gdx) {
		this.gdx = gdx;
	}
	public String getGdy() {
		return gdy;
	}
	public void setGdy(String gdy) {
		this.gdy = gdy;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
