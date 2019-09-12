package com.ltsk.whcg.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Bridge implements Serializable {
    private BigDecimal keyid;

    private String bridgename;

    private String bridgetype;

    private double gdx;

    private double gdy;

    private String gpsdes;

    private BigDecimal bridgelength;

    private String maintaintypename;

    private String maintainlevel="暂无";

    private String frontalviewpic;

    private String sideviewpic;

    private static final long serialVersionUID = 1L;

    public BigDecimal getKeyid() {
        return keyid;
    }

    public void setKeyid(BigDecimal keyid) {
        this.keyid = keyid;
    }

    public String getBridgename() {
        return bridgename;
    }

    public void setBridgename(String bridgename) {
        this.bridgename = bridgename == null ? "" : bridgename.trim();
    }

    public String getBridgetype() {
        return bridgetype;
    }

    public void setBridgetype(String bridgetype) {
        this.bridgetype = bridgetype == null ? "" : bridgetype.trim();
    }

    public double getGdx() {
        return gdx;
    }

    public void setGdx(double gdx) {
        this.gdx = gdx;
    }

    public double getGdy() {
        return gdy;
    }

    public void setGdy(double gdy) {
        this.gdy = gdy;
    }

    public String getGpsdes() {
        return gpsdes;
    }

    public void setGpsdes(String gpsdes) {
        this.gpsdes = gpsdes == null ? "" : gpsdes.trim();
    }

    public BigDecimal getBridgelength() {
        return bridgelength;
    }

    public void setBridgelength(BigDecimal bridgelength) {
        this.bridgelength = bridgelength;
    }

    public String getMaintaintypename() {
        return maintaintypename;
    }

    public void setMaintaintypename(String maintaintypename) {
        this.maintaintypename = maintaintypename == null ? "" : maintaintypename.trim();
    }

    public String getMaintainlevel() {
        return maintainlevel;
    }

    public void setMaintainlevel(String maintainlevel) {
        this.maintainlevel = maintainlevel == null ? "" : maintainlevel.trim();
    }

    public String getFrontalviewpic() {
        return frontalviewpic;
    }

    public void setFrontalviewpic(String frontalviewpic) {
        this.frontalviewpic = frontalviewpic == null ? "" : frontalviewpic.trim();
    }

    public String getSideviewpic() {
        return sideviewpic;
    }

    public void setSideviewpic(String sideviewpic) {
        this.sideviewpic = sideviewpic == null ? "" : sideviewpic.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", keyid=").append(keyid);
        sb.append(", bridgename=").append(bridgename);
        sb.append(", bridgetype=").append(bridgetype);
        sb.append(", gdx=").append(gdx);
        sb.append(", gdy=").append(gdy);
        sb.append(", gpsdes=").append(gpsdes);
        sb.append(", bridgelength=").append(bridgelength);
        sb.append(", maintaintypename=").append(maintaintypename);
        sb.append(", maintainlevel=").append(maintainlevel);
        sb.append(", frontalviewpic=").append(frontalviewpic);
        sb.append(", sideviewpic=").append(sideviewpic);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}