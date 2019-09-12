package com.ltsk.whcg.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Gasstation implements Serializable {
    private BigDecimal id;

    private String stationNum;

    private String name;

    private BigDecimal stationTypeId;

    private BigDecimal districtId;

    private String address;

    private String contacts;

    private String contactTel;

    private String securityContacts;

    private String securityContactTel;

    private BigDecimal securityLevelId;

    private String establishTime;

    private BigDecimal enterpriseId;

    private String expirationDate;

    private BigDecimal banStatus;

    private BigDecimal auditStatus;

    private BigDecimal auditId;

    private BigDecimal banId;

    private BigDecimal updateId;

    private BigDecimal authorId;

    private BigDecimal thetime;

    private BigDecimal sort;

    private String stationTypeCn;

    private String districtCn;

    private String enterpriseCn;

    private String authorCn;

    private String gdx;

    private String gdy;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getStationNum() {
        return stationNum;
    }

    public void setStationNum(String stationNum) {
        this.stationNum = stationNum == null ? "" : stationNum.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name.trim();
    }

    public BigDecimal getStationTypeId() {
        return stationTypeId;
    }

    public void setStationTypeId(BigDecimal stationTypeId) {
        this.stationTypeId = stationTypeId;
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

    public String getSecurityContacts() {
        return securityContacts;
    }

    public void setSecurityContacts(String securityContacts) {
        this.securityContacts = securityContacts == null ? "" : securityContacts.trim();
    }

    public String getSecurityContactTel() {
        return securityContactTel;
    }

    public void setSecurityContactTel(String securityContactTel) {
        this.securityContactTel = securityContactTel == null ? "" : securityContactTel.trim();
    }

    public BigDecimal getSecurityLevelId() {
        return securityLevelId;
    }

    public void setSecurityLevelId(BigDecimal securityLevelId) {
        this.securityLevelId = securityLevelId;
    }

    public String getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(String establishTime) {
        this.establishTime = establishTime == null ? "" : establishTime.trim();
    }

    public BigDecimal getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(BigDecimal enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate == null ? "" : expirationDate.trim();
    }

    public BigDecimal getBanStatus() {
        return banStatus;
    }

    public void setBanStatus(BigDecimal banStatus) {
        this.banStatus = banStatus;
    }

    public BigDecimal getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(BigDecimal auditStatus) {
        this.auditStatus = auditStatus;
    }

    public BigDecimal getAuditId() {
        return auditId;
    }

    public void setAuditId(BigDecimal auditId) {
        this.auditId = auditId;
    }

    public BigDecimal getBanId() {
        return banId;
    }

    public void setBanId(BigDecimal banId) {
        this.banId = banId;
    }

    public BigDecimal getUpdateId() {
        return updateId;
    }

    public void setUpdateId(BigDecimal updateId) {
        this.updateId = updateId;
    }

    public BigDecimal getAuthorId() {
        return authorId;
    }

    public void setAuthorId(BigDecimal authorId) {
        this.authorId = authorId;
    }

    public BigDecimal getThetime() {
        return thetime;
    }

    public void setThetime(BigDecimal thetime) {
        this.thetime = thetime;
    }

    public BigDecimal getSort() {
        return sort;
    }

    public void setSort(BigDecimal sort) {
        this.sort = sort;
    }

    public String getStationTypeCn() {
        return stationTypeCn;
    }

    public void setStationTypeCn(String stationTypeCn) {
        this.stationTypeCn = stationTypeCn == null ? "" : stationTypeCn.trim();
    }

    public String getDistrictCn() {
        return districtCn;
    }

    public void setDistrictCn(String districtCn) {
        this.districtCn = districtCn == null ? "" : districtCn.trim();
    }

    public String getEnterpriseCn() {
        return enterpriseCn;
    }

    public void setEnterpriseCn(String enterpriseCn) {
        this.enterpriseCn = enterpriseCn == null ? "" : enterpriseCn.trim();
    }

    public String getAuthorCn() {
        return authorCn;
    }

    public void setAuthorCn(String authorCn) {
        this.authorCn = authorCn == null ? "" : authorCn.trim();
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
        sb.append(", id=").append(id);
        sb.append(", stationNum=").append(stationNum);
        sb.append(", name=").append(name);
        sb.append(", stationTypeId=").append(stationTypeId);
        sb.append(", districtId=").append(districtId);
        sb.append(", address=").append(address);
        sb.append(", contacts=").append(contacts);
        sb.append(", contactTel=").append(contactTel);
        sb.append(", securityContacts=").append(securityContacts);
        sb.append(", securityContactTel=").append(securityContactTel);
        sb.append(", securityLevelId=").append(securityLevelId);
        sb.append(", establishTime=").append(establishTime);
        sb.append(", enterpriseId=").append(enterpriseId);
        sb.append(", expirationDate=").append(expirationDate);
        sb.append(", banStatus=").append(banStatus);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", auditId=").append(auditId);
        sb.append(", banId=").append(banId);
        sb.append(", updateId=").append(updateId);
        sb.append(", authorId=").append(authorId);
        sb.append(", thetime=").append(thetime);
        sb.append(", sort=").append(sort);
        sb.append(", stationTypeCn=").append(stationTypeCn);
        sb.append(", districtCn=").append(districtCn);
        sb.append(", enterpriseCn=").append(enterpriseCn);
        sb.append(", authorCn=").append(authorCn);
        sb.append(", gdx=").append(gdx);
        sb.append(", gdy=").append(gdy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}