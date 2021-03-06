package com.ltsk.whcg.entity;



public class WarningList {

    private int w_id;
    private int devicetype;
    private int devicechildtype;
    private String deviceAddr;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String occurdate;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String recoverydate;
    private int warninglevel;
    private String warningcontent;
    private int status;
    private int  wxstatus;
    private String suggestion;
    private String stationid;
    private String treament;
    private String areaname;
    private String departname;

    public int getW_id() {
        return w_id;
    }

    public void setW_id(int w_id) {
        this.w_id = w_id;
    }

    public int getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(int devicetype) {
        this.devicetype = devicetype;
    }

    public int getDevicechildtype() {
        return devicechildtype;
    }

    public void setDevicechildtype(int devicechildtype) {
        this.devicechildtype = devicechildtype;
    }

    public String getDeviceAddr() {
        return deviceAddr;
    }

    public void setDeviceAddr(String deviceAddr) {
        this.deviceAddr = deviceAddr;
    }

    public String getOccurdate() {
        return occurdate;
    }

    public void setOccurdate(String occurdate) {
        this.occurdate = occurdate;
    }

    public String getRecoverydate() {
        return recoverydate;
    }

    public void setRecoverydate(String recoverydate) {
        this.recoverydate = recoverydate;
    }

    public int getWarninglevel() {
        return warninglevel;
    }

    public void setWarninglevel(int warninglevel) {
        this.warninglevel = warninglevel;
    }

    public String getWarningcontent() {
        return warningcontent;
    }

    public void setWarningcontent(String warningcontent) {
        this.warningcontent = warningcontent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getWxstatus() {
        return wxstatus;
    }

    public void setWxstatus(int wxstatus) {
        this.wxstatus = wxstatus;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getStationid() {
        return stationid;
    }

    public void setStationid(String stationid) {
        this.stationid = stationid;
    }

    public String getTreament() {
        return treament;
    }

    public void setTreament(String treament) {
        this.treament = treament;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    @Override
    public String toString() {
        return "WarningList{" +
                "w_id=" + w_id +
                ", devicetype=" + devicetype +
                ", devicechildtype=" + devicechildtype +
                ", deviceAddr='" + deviceAddr + '\'' +
                ", occurdate=" + occurdate +
                ", recoverydate=" + recoverydate +
                ", warninglevel=" + warninglevel +
                ", warningcontent='" + warningcontent + '\'' +
                ", status=" + status +
                ", wxstatus=" + wxstatus +
                ", suggestion='" + suggestion + '\'' +
                ", stationid='" + stationid + '\'' +
                ", treament='" + treament + '\'' +
                ", areaname='" + areaname + '\'' +
                ", departname='" + departname + '\'' +
                '}';
    }
}
