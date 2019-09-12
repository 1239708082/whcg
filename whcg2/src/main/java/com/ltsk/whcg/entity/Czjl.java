package com.ltsk.whcg.entity;


import java.io.Serializable;


public class Czjl implements Serializable {
    private Object id;

    private Object carno;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String grossdatetime;

    private Object grossweight;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String taredatetime;

    private Object tareweight;

    private Object transportunit;

    private Object productname;

    private Object netweight;

    private Object productinorout;

    private Object dataoperatetype;

    private Object area;

    private String handleunit;

    private static final long serialVersionUID = 1L;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getCarno() {
        return carno;
    }

    public void setCarno(Object carno) {
        this.carno = carno;
    }

    public String getGrossdatetime() {
        return grossdatetime;
    }

    public void setGrossdatetime(String grossdatetime) {
        this.grossdatetime = grossdatetime;
    }

    public Object getGrossweight() {
        return grossweight;
    }

    public void setGrossweight(Object grossweight) {
        this.grossweight = grossweight;
    }

    public String getTaredatetime() {
        return taredatetime;
    }

    public void setTaredatetime(String taredatetime) {
        this.taredatetime = taredatetime;
    }

    public Object getTareweight() {
        return tareweight;
    }

    public void setTareweight(Object tareweight) {
        this.tareweight = tareweight;
    }

    public Object getTransportunit() {
        return transportunit;
    }

    public void setTransportunit(Object transportunit) {
        this.transportunit = transportunit;
    }

    public Object getProductname() {
        return productname;
    }

    public void setProductname(Object productname) {
        this.productname = productname;
    }

    public Object getNetweight() {
        return netweight;
    }

    public void setNetweight(Object netweight) {
        this.netweight = netweight;
    }

    public Object getProductinorout() {
        return productinorout;
    }

    public void setProductinorout(Object productinorout) {
        this.productinorout = productinorout;
    }

    public Object getDataoperatetype() {
        return dataoperatetype;
    }

    public void setDataoperatetype(Object dataoperatetype) {
        this.dataoperatetype = dataoperatetype;
    }

    public Object getArea() {
        return area;
    }

    public void setArea(Object area) {
        this.area = area;
    }

    public String getHandleunit() {
        return handleunit;
    }

    public void setHandleunit(String handleunit) {
        this.handleunit = handleunit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", carno=").append(carno);
        sb.append(", grossdatetime=").append(grossdatetime);
        sb.append(", grossweight=").append(grossweight);
        sb.append(", taredatetime=").append(taredatetime);
        sb.append(", tareweight=").append(tareweight);
        sb.append(", transportunit=").append(transportunit);
        sb.append(", productname=").append(productname);
        sb.append(", netweight=").append(netweight);
        sb.append(", productinorout=").append(productinorout);
        sb.append(", dataoperatetype=").append(dataoperatetype);
        sb.append(", area=").append(area);
        sb.append(", handleunit=").append(handleunit);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}