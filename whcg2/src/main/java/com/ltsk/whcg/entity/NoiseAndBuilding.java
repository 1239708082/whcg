package com.ltsk.whcg.entity;


import java.io.Serializable;

public class NoiseAndBuilding implements Serializable {
	private static final long serialVersionUID = 1L;
	private int complaint_id;
    private String small_name;
    private String source_name;
    private String complaint_time;
    private int complainer;
    private String complainer_name;
    private String complainer_tel;
    private String complainer_connect;
    private String title;
    private String content;
    private String addr;
    private String zone_name;
    private Double location_x;
    private Double location_y;
    private String name;
    private int event_id;

    public int getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(int complaint_id) {
        this.complaint_id = complaint_id;
    }

    public String getSmall_name() {
        return small_name;
    }

    public void setSmall_name(String small_name) {
        this.small_name = small_name;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getComplaint_time() {
        return complaint_time;
    }

    public void setComplaint_time(String complaint_time) {
        this.complaint_time = complaint_time;
    }

    public int getComplainer() {
        return complainer;
    }

    public void setComplainer(int complainer) {
        this.complainer = complainer;
    }

    public String getComplainer_name() {
        return complainer_name;
    }

    public void setComplainer_name(String complainer_name) {
        this.complainer_name = complainer_name;
    }

    public String getComplainer_tel() {
        return complainer_tel;
    }

    public void setComplainer_tel(String complainer_tel) {
        this.complainer_tel = complainer_tel;
    }

    public String getComplainer_connect() {
        return complainer_connect;
    }

    public void setComplainer_connect(String complainer_connect) {
        this.complainer_connect = complainer_connect;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getZone_name() {
        return zone_name;
    }

    public void setZone_name(String zone_name) {
        this.zone_name = zone_name;
    }

    public Double getLocation_x() {
        return location_x;
    }

    public void setLocation_x(Double location_x) {
        this.location_x = location_x;
    }

    public Double getLocation_y() {
        return location_y;
    }

    public void setLocation_y(Double location_y) {
        this.location_y = location_y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    @Override
    public String toString() {
        return "NoiseAndBuilding{" +
                "complaint_id=" + complaint_id +
                ", small_name='" + small_name + '\'' +
                ", source_name='" + source_name + '\'' +
                ", complaint_time=" + complaint_time +
                ", complainer=" + complainer +
                ", complainer_name='" + complainer_name + '\'' +
                ", complainer_tel='" + complainer_tel + '\'' +
                ", complainer_connect='" + complainer_connect + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", addr='" + addr + '\'' +
                ", zone_name='" + zone_name + '\'' +
                ", location_x=" + location_x +
                ", location_y=" + location_y +
                ", name='" + name + '\'' +
                ", event_id=" + event_id +
                '}';
    }
}
