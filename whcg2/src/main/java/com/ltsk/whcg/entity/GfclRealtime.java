package com.ltsk.whcg.entity;

import java.io.Serializable;

public class GfclRealtime implements Serializable {
    private Object id;

    private Object carcode;

    private Object xzqhcode;

    private Object carbreedname;

    private Object speed;

    private Object xzqhname;

    private Object carstatus;

    private Object equipmenttime;

    private Object latitudedone;

    private Object longitudedone;

    private Object carclassesname;

    private Object driver;

    private Object useunitname;

    private static final long serialVersionUID = 1L;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getCarcode() {
        return carcode;
    }

    public void setCarcode(Object carcode) {
        this.carcode = carcode;
    }

    public Object getXzqhcode() {
        return xzqhcode;
    }

    public void setXzqhcode(Object xzqhcode) {
        this.xzqhcode = xzqhcode;
    }

    public Object getCarbreedname() {
        return carbreedname;
    }

    public void setCarbreedname(Object carbreedname) {
        this.carbreedname = carbreedname;
    }

    public Object getSpeed() {
        return speed;
    }

    public void setSpeed(Object speed) {
        this.speed = speed;
    }

    public Object getXzqhname() {
        return xzqhname;
    }

    public void setXzqhname(Object xzqhname) {
        this.xzqhname = xzqhname;
    }

    public Object getCarstatus() {
        return carstatus;
    }

    public void setCarstatus(Object carstatus) {
        this.carstatus = carstatus;
    }

    public Object getEquipmenttime() {
        return equipmenttime;
    }

    public void setEquipmenttime(Object equipmenttime) {
        this.equipmenttime = equipmenttime;
    }

    public Object getLatitudedone() {
        return latitudedone;
    }

    public void setLatitudedone(Object latitudedone) {
        this.latitudedone = latitudedone;
    }

    public Object getLongitudedone() {
        return longitudedone;
    }

    public void setLongitudedone(Object longitudedone) {
        this.longitudedone = longitudedone;
    }

    public Object getCarclassesname() {
        return carclassesname;
    }

    public void setCarclassesname(Object carclassesname) {
        this.carclassesname = carclassesname;
    }

    public Object getDriver() {
        return driver;
    }

    public void setDriver(Object driver) {
        this.driver = driver;
    }

    public Object getUseunitname() {
        return useunitname;
    }

    public void setUseunitname(Object useunitname) {
        this.useunitname = useunitname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", carcode=").append(carcode);
        sb.append(", xzqhcode=").append(xzqhcode);
        sb.append(", carbreedname=").append(carbreedname);
        sb.append(", speed=").append(speed);
        sb.append(", xzqhname=").append(xzqhname);
        sb.append(", carstatus=").append(carstatus);
        sb.append(", equipmenttime=").append(equipmenttime);
        sb.append(", latitudedone=").append(latitudedone);
        sb.append(", longitudedone=").append(longitudedone);
        sb.append(", carclassesname=").append(carclassesname);
        sb.append(", driver=").append(driver);
        sb.append(", useunitname=").append(useunitname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}