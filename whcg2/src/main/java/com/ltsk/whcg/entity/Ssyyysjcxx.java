package com.ltsk.whcg.entity;


import java.io.Serializable;

public class Ssyyysjcxx implements Serializable {
    private String cleanerswitch;

    private String fanswitch;

    private String concentrationin;

    private String hotelname;

    private String concentrationout;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createtime;

    private String cleanercurrent;

    private String fancurrent;

    private static final long serialVersionUID = 1L;

    public String getCleanerswitch() {
        return cleanerswitch;
    }

    public void setCleanerswitch(String cleanerswitch) {
        this.cleanerswitch = cleanerswitch == null ? "" : cleanerswitch.trim();
    }

    public String getFanswitch() {
        return fanswitch;
    }

    public void setFanswitch(String fanswitch) {
        this.fanswitch = fanswitch == null ? "" : fanswitch.trim();
    }

    public String getConcentrationin() {
        return concentrationin;
    }

    public void setConcentrationin(String concentrationin) {
        this.concentrationin = concentrationin == null ? "" : concentrationin.trim();
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname == null ? "" : hotelname.trim();
    }

    public String getConcentrationout() {
        return concentrationout;
    }

    public void setConcentrationout(String concentrationout) {
        this.concentrationout = concentrationout == null ? "" : concentrationout.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCleanercurrent() {
        return cleanercurrent;
    }

    public void setCleanercurrent(String cleanercurrent) {
        this.cleanercurrent = cleanercurrent == null ? "" : cleanercurrent.trim();
    }

    public String getFancurrent() {
        return fancurrent;
    }

    public void setFancurrent(String fancurrent) {
        this.fancurrent = fancurrent == null ? "" : fancurrent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cleanerswitch=").append(cleanerswitch);
        sb.append(", fanswitch=").append(fanswitch);
        sb.append(", concentrationin=").append(concentrationin);
        sb.append(", hotelname=").append(hotelname);
        sb.append(", concentrationout=").append(concentrationout);
        sb.append(", createtime=").append(createtime);
        sb.append(", cleanercurrent=").append(cleanercurrent);
        sb.append(", fancurrent=").append(fancurrent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}