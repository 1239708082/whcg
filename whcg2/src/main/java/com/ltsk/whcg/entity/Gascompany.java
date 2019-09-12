package com.ltsk.whcg.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Gascompany implements Serializable {
    private BigDecimal id;

    private String enterpriseNum;

    private String name;

    private BigDecimal enterpriseTypeId;

    private BigDecimal districtId;

    private String address;

    private String contacts;

    private String contactTel;

    private String establishTime;

    private String supervisionDepartment;

    private BigDecimal totalPeople;

    private String longitude;

    private String latitude;

    private BigDecimal status;

    private BigDecimal authorId;

    private String thetime;

    private BigDecimal sort;

    private String distributorKey;

    private String enterpriseTypeCn;

    private String districtCn;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEnterpriseNum() {
        return enterpriseNum;
    }

    public void setEnterpriseNum(String enterpriseNum) {
        this.enterpriseNum = enterpriseNum == null ? "" : enterpriseNum.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name.trim();
    }

    public BigDecimal getEnterpriseTypeId() {
        return enterpriseTypeId;
    }

    public void setEnterpriseTypeId(BigDecimal enterpriseTypeId) {
        this.enterpriseTypeId = enterpriseTypeId;
    }

    public BigDecimal getDistrictId() {
        return districtId;
    }

    public void setDistrictId(BigDecimal districtId) {
        this.districtId = districtId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? "" : address.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? "" : contacts.trim();
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? "" : contactTel.trim();
    }

    public String getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(String establishTime) {
        this.establishTime = establishTime == null ? "" : establishTime.trim();
    }

    public String getSupervisionDepartment() {
        return supervisionDepartment;
    }

    public void setSupervisionDepartment(String supervisionDepartment) {
        this.supervisionDepartment = supervisionDepartment == null ? "" : supervisionDepartment.trim();
    }

    public BigDecimal getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(BigDecimal totalPeople) {
        this.totalPeople = totalPeople;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? "" : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? "" : latitude.trim();
    }

    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
    }

    public BigDecimal getAuthorId() {
        return authorId;
    }

    public void setAuthorId(BigDecimal authorId) {
        this.authorId = authorId;
    }

    public String getThetime() {
        return thetime;
    }

    public void setThetime(String thetime) {
        this.thetime = thetime == null ? "" : thetime.trim();
    }

    public BigDecimal getSort() {
        return sort;
    }

    public void setSort(BigDecimal sort) {
        this.sort = sort;
    }

    public String getDistributorKey() {
        return distributorKey;
    }

    public void setDistributorKey(String distributorKey) {
        this.distributorKey = distributorKey == null ? "" : distributorKey.trim();
    }

    public String getEnterpriseTypeCn() {
        return enterpriseTypeCn;
    }

    public void setEnterpriseTypeCn(String enterpriseTypeCn) {
        this.enterpriseTypeCn = enterpriseTypeCn == null ? "" : enterpriseTypeCn.trim();
    }

    public String getDistrictCn() {
        return districtCn;
    }

    public void setDistrictCn(String districtCn) {
        this.districtCn = districtCn == null ? "" : districtCn.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", enterpriseNum=").append(enterpriseNum);
        sb.append(", name=").append(name);
        sb.append(", enterpriseTypeId=").append(enterpriseTypeId);
        sb.append(", districtId=").append(districtId);
        sb.append(", address=").append(address);
        sb.append(", contacts=").append(contacts);
        sb.append(", contactTel=").append(contactTel);
        sb.append(", establishTime=").append(establishTime);
        sb.append(", supervisionDepartment=").append(supervisionDepartment);
        sb.append(", totalPeople=").append(totalPeople);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", status=").append(status);
        sb.append(", authorId=").append(authorId);
        sb.append(", thetime=").append(thetime);
        sb.append(", sort=").append(sort);
        sb.append(", distributorKey=").append(distributorKey);
        sb.append(", enterpriseTypeCn=").append(enterpriseTypeCn);
        sb.append(", districtCn=").append(districtCn);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}