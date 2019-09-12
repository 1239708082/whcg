package com.ltsk.whcg.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ServerProcess {
    private String id;
    private String username;
    private String fwname;
    private String state;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String insertTime;
    private String chineseName;

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFwname() {
        return fwname;
    }

    public void setFwname(String fwname) {
        this.fwname = fwname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }
}
