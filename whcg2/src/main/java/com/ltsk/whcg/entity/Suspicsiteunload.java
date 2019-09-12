package com.ltsk.whcg.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Suspicsiteunload implements Serializable {
    private int id;

    private double gdx;

    private double gdy;

    private String name;

    private String barriertype;

    private String updatetime;

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
        this.name = name;
    }

    public String getBarriertype() {
        return barriertype;
    }

    public void setBarriertype(String barriertype) {
        this.barriertype = barriertype;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "Suspicsiteunload{" +
                "id=" + id +
                ", gdx=" + gdx +
                ", gdy=" + gdy +
                ", name='" + name + '\'' +
                ", barriertype='" + barriertype + '\'' +
                ", updatetime=" + updatetime +
                '}';
    }
}