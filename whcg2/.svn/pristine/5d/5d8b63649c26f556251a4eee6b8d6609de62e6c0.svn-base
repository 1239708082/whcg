package com.ltsk.whcg.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @program: big_screen_display
 * @description: 结果
 * @author: Mr.Wang
 * @create: 2018-10-23 14:37
 **/
public class Result {

    private boolean success;

    private String msg;

    private Object data;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Object time;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Integer num;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Object area;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Object handleunit;
    
    
    public Object getHandleunit() {
		return handleunit;
	}

	public void setHandleunit(Object handleunit) {
		this.handleunit = handleunit;
	}

	public Object getArea() {
		return area;
	}

	public void setArea(Object area) {
		this.area = area;
	}

	public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public Object getTime() {
        return time;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setTime(Object time) {
        this.time = time;
    }

    public Result(boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public Result(boolean success, String msg, Object data, Object time) {
        this.success = success;
        this.msg = msg;
        this.data = data;
        this.time = time;
    }

    public Result(boolean success, String msg, Object data, Object time, Integer num) {
        this.success = success;
        this.msg = msg;
        this.data = data;
        this.time = time;
        this.num = num;
    }

    public Result() {
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", time=" + time +
                ", num=" + num +
                '}';
    }
}
