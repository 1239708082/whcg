package com.ltsk.whcg.entity;


import java.io.Serializable;

public class Muck implements Serializable {
    private String vehicleno;

    private String deviceno;

    private String lon;

    private String lat;

    private String gpsdatetime;

    private String address="暂无";

    private String vehiclestatus;

    private String vehiclestatusid;

    private String direction;

    private String name;

    private String isgpsico;

    private String iscomico;

    private String cameranum;

    private String terminalid;

    private String gdx="暂无";

    private String gdy="暂无";

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updatetime;

    private static final long serialVersionUID = 1L;

    public String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno == null ? "" : vehicleno.trim();
    }

    public String getDeviceno() {
        return deviceno;
    }

    public void setDeviceno(String deviceno) {
        this.deviceno = deviceno == null ? "" : deviceno.trim();
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon == null ? "" : lon.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? "" : lat.trim();
    }

    public String getGpsdatetime() {
        return gpsdatetime;
    }

    public void setGpsdatetime(String gpsdatetime) {
        this.gpsdatetime = gpsdatetime == null ? "" : gpsdatetime.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? "" : address.trim();
    }

    public String getVehiclestatus() {
        return vehiclestatus;
    }

    public void setVehiclestatus(String vehiclestatus) {
        this.vehiclestatus = vehiclestatus == null ? "" : vehiclestatus.trim();
    }

    public String getVehiclestatusid() {
        return vehiclestatusid;
    }

    public void setVehiclestatusid(String vehiclestatusid) {
        this.vehiclestatusid = vehiclestatusid == null ? "" : vehiclestatusid.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? "" : direction.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name.trim();
    }

    public String getIsgpsico() {
        return isgpsico;
    }

    public void setIsgpsico(String isgpsico) {
        this.isgpsico = isgpsico == null ? "" : isgpsico.trim();
    }

    public String getIscomico() {
        return iscomico;
    }

    public void setIscomico(String iscomico) {
        this.iscomico = iscomico == null ? "" : iscomico.trim();
    }

    public String getCameranum() {
        return cameranum;
    }

    public void setCameranum(String cameranum) {
        this.cameranum = cameranum == null ? "" : cameranum.trim();
    }

    public String getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(String terminalid) {
        this.terminalid = terminalid == null ? "" : terminalid.trim();
    }

    public String getGdx() {
        return gdx;
    }

    public void setGdx(String gdx) {
        this.gdx = gdx == null ? "" : gdx.trim();
    }

    public String getGdy() {
        return gdy;
    }

    public void setGdy(String gdy) {
        this.gdy = gdy == null ? "" : gdy.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", vehicleno=").append(vehicleno);
        sb.append(", deviceno=").append(deviceno);
        sb.append(", lon=").append(lon);
        sb.append(", lat=").append(lat);
        sb.append(", gpsdatetime=").append(gpsdatetime);
        sb.append(", address=").append(address);
        sb.append(", vehiclestatus=").append(vehiclestatus);
        sb.append(", vehiclestatusid=").append(vehiclestatusid);
        sb.append(", direction=").append(direction);
        sb.append(", name=").append(name);
        sb.append(", isgpsico=").append(isgpsico);
        sb.append(", iscomico=").append(iscomico);
        sb.append(", cameranum=").append(cameranum);
        sb.append(", terminalid=").append(terminalid);
        sb.append(", gdx=").append(gdx);
        sb.append(", gdy=").append(gdy);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}