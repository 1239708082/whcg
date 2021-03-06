package com.ltsk.whcg.entity;


import java.io.Serializable;

public class Cyyycginfo implements Serializable {
    private String district;

    private String telephone="暂无";

    private String lng;

    private String hotelname;

    private String address="暂无";

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createdate="暂无";

    private String manager="暂无";

    private String openinghours="暂无";

    private String street="暂无";

    private String openingstatus="暂无";

    private String lat;

    private String chargeman="暂无";

    private String gdx;

    private String gdy;

    private static final long serialVersionUID = 1L;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? "" : district.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? "" : telephone.trim();
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? "" : lng.trim();
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname == null ? "" : hotelname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? "" : address.trim();
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? "" : manager.trim();
    }

    public String getOpeninghours() {
        return openinghours;
    }

    public void setOpeninghours(String openinghours) {
        this.openinghours = openinghours == null ? "" : openinghours.trim();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? "" : street.trim();
    }

    public String getOpeningstatus() {
        return openingstatus;
    }

    public void setOpeningstatus(String openingstatus) {
        this.openingstatus = openingstatus == null ? "" : openingstatus.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? "" : lat.trim();
    }

    public String getChargeman() {
        return chargeman;
    }

    public void setChargeman(String chargeman) {
        this.chargeman = chargeman == null ? "" : chargeman.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", district=").append(district);
        sb.append(", telephone=").append(telephone);
        sb.append(", lng=").append(lng);
        sb.append(", hotelname=").append(hotelname);
        sb.append(", address=").append(address);
        sb.append(", createdate=").append(createdate);
        sb.append(", manager=").append(manager);
        sb.append(", openinghours=").append(openinghours);
        sb.append(", street=").append(street);
        sb.append(", openingstatus=").append(openingstatus);
        sb.append(", lat=").append(lat);
        sb.append(", chargeman=").append(chargeman);
        sb.append(", gdx=").append(gdx);
        sb.append(", gdy=").append(gdy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}