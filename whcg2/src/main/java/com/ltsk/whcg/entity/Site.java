package com.ltsk.whcg.entity;


import java.io.Serializable;

public class Site implements Serializable {
    private int id;

    private double gdx;

    private double gdy;

    private String name;

    private String barriertype;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updatetime;

    private static final long serialVersionUID = 1L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name.trim();
    }

    public String getBarriertype() {
        return barriertype;
    }

    public void setBarriertype(String barriertype) {
        this.barriertype = barriertype == null ? "" : barriertype.trim();
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
        sb.append(", id=").append(id);
        sb.append(", gdx=").append(gdx);
        sb.append(", gdy=").append(gdy);
        sb.append(", name=").append(name);
        sb.append(", barriertype=").append(barriertype);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}