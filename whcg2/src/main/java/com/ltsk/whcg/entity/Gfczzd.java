package com.ltsk.whcg.entity;


import java.io.Serializable;

public class Gfczzd implements Serializable {
    private Object gid;

    private Object name;

    private Object xzqhname;

    private Object handleability;

    private Object orderindex;

    private Object longitudedone;

    private Object latitudedone;

    private Object netweight;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updatetime;

    private static final long serialVersionUID = 1L;

    public Object getGid() {
        return gid;
    }

    public void setGid(Object gid) {
        this.gid = gid;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getXzqhname() {
        return xzqhname;
    }

    public void setXzqhname(Object xzqhname) {
        this.xzqhname = xzqhname;
    }

    public Object getHandleability() {
        return handleability;
    }

    public void setHandleability(Object handleability) {
        this.handleability = handleability;
    }

    public Object getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(Object orderindex) {
        this.orderindex = orderindex;
    }

    public Object getLongitudedone() {
        return longitudedone;
    }

    public void setLongitudedone(Object longitudedone) {
        this.longitudedone = longitudedone;
    }

    public Object getLatitudedone() {
        return latitudedone;
    }

    public void setLatitudedone(Object latitudedone) {
        this.latitudedone = latitudedone;
    }

    public Object getNetweight() {
        return netweight;
    }

    public void setNetweight(Object netweight) {
        this.netweight = netweight;
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
        sb.append(", gid=").append(gid);
        sb.append(", name=").append(name);
        sb.append(", xzqhname=").append(xzqhname);
        sb.append(", handleability=").append(handleability);
        sb.append(", orderindex=").append(orderindex);
        sb.append(", longitudedone=").append(longitudedone);
        sb.append(", latitudedone=").append(latitudedone);
        sb.append(", netweight=").append(netweight);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}