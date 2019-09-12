package com.ltsk.whcg.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

//餐厨油烟报警信息
public class LampBlack {
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private Integer id;
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String hotelname;// 店名
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String alarmvalue = "";// 报警值
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String alarmtime; // 报警时间
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String alarmtype;// 报警类型
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String x; //经度
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String y;//纬度
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String warningType;//事件类型
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private Integer num;
	
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getAlarmvalue() {
		return alarmvalue;
	}
	public void setAlarmvalue(String alarmvalue) {
		this.alarmvalue = alarmvalue;
	}
	public String getAlarmtime() {
		return alarmtime;
	}
	public void setAlarmtime(String alarmtime) {
		this.alarmtime = alarmtime;
	}
	public String getAlarmtype() {
		return alarmtype;
	}
	public void setAlarmtype(String alarmtype) {
		this.alarmtype = alarmtype;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getWarningType() {
		return warningType;
	}
	public void setWarningType(String warningType) {
		this.warningType = warningType;
	}
	@Override
	public String toString() {
		return "LampBlack [id=" + id + ", hotelname=" + hotelname + ", alarmvalue=" + alarmvalue + ", alarmtime="
				+ alarmtime + ", alarmtype=" + alarmtype + ", x=" + x + ", y=" + y + ", warningType=" + warningType
				+ "]";
	}

	
	
	
	
}
