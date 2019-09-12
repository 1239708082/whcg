package com.ltsk.whcg.entity;


import java.io.Serializable;

public class Yyssldb implements Serializable {
    private String hotelname;

    private String cleanerruntime;

    private String linkscale;

    private String fanruntime;

    private String openingstatus;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updatetime;

    private static final long serialVersionUID = 1L;

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname == null ? "" : hotelname.trim();
    }

    public String getCleanerruntime() {
        return cleanerruntime;
    }

    public void setCleanerruntime(String cleanerruntime) {
        this.cleanerruntime = cleanerruntime == null ? "" : cleanerruntime.trim();
    }

    public String getLinkscale() {
        return linkscale;
    }

    public void setLinkscale(String linkscale) {
        this.linkscale = linkscale == null ? "" : linkscale.trim();
    }

    public String getFanruntime() {
        return fanruntime;
    }

    public void setFanruntime(String fanruntime) {
        this.fanruntime = fanruntime == null ? "" : fanruntime.trim();
    }

    public String getOpeningstatus() {
        return openingstatus;
    }

    public void setOpeningstatus(String openingstatus) {
        this.openingstatus = openingstatus == null ? "" : openingstatus.trim();
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
        sb.append(", hotelname=").append(hotelname);
        sb.append(", cleanerruntime=").append(cleanerruntime);
        sb.append(", linkscale=").append(linkscale);
        sb.append(", fanruntime=").append(fanruntime);
        sb.append(", openingstatus=").append(openingstatus);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}