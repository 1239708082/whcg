package com.ltsk.whcg.entity;


import java.io.Serializable;

public class Yyssqjd implements Serializable {
    private String cleanliness0;

    private String cleanliness2;

    private String cleanliness1;

    private String hotelname;

    private String cleanliness3;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updatetime;

    private static final long serialVersionUID = 1L;

    public String getCleanliness0() {
        return cleanliness0;
    }

    public void setCleanliness0(String cleanliness0) {
        this.cleanliness0 = cleanliness0 == null ? "" : cleanliness0.trim();
    }

    public String getCleanliness2() {
        return cleanliness2;
    }

    public void setCleanliness2(String cleanliness2) {
        this.cleanliness2 = cleanliness2 == null ? "" : cleanliness2.trim();
    }

    public String getCleanliness1() {
        return cleanliness1;
    }

    public void setCleanliness1(String cleanliness1) {
        this.cleanliness1 = cleanliness1 == null ? "" : cleanliness1.trim();
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname == null ? "" : hotelname.trim();
    }

    public String getCleanliness3() {
        return cleanliness3;
    }

    public void setCleanliness3(String cleanliness3) {
        this.cleanliness3 = cleanliness3 == null ? "" : cleanliness3.trim();
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
        sb.append(", cleanliness0=").append(cleanliness0);
        sb.append(", cleanliness2=").append(cleanliness2);
        sb.append(", cleanliness1=").append(cleanliness1);
        sb.append(", hotelname=").append(hotelname);
        sb.append(", cleanliness3=").append(cleanliness3);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}