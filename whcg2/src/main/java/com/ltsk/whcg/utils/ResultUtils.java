package com.ltsk.whcg.utils;

/**
 * @program: big_screen_display
 * @description: 返回结果包装工具类
 * @author: Mr.Wang
 * @create: 2018-10-23 14:33
 **/
public class ResultUtils {

    public static Result success(Object object) {
        Result result = new Result();
        result.setData(object);
        result.setSuccess(true);
        result.setMsg("成功");
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(msg);
        return result;
    }

    public static Result success(Object object,String time) {
        Result result = new Result();
        result.setData(object);
        result.setSuccess(true);
        result.setMsg("成功");
        result.setTime(time);
        return result;
    }

    public static Result success(Object object, String time,Integer num) {
        Result result = new Result();
        result.setData(object);
        result.setSuccess(true);
        result.setMsg("成功");
        result.setTime(time);
        result.setNum(num);
        return result;
    }
    public static Result success(Object object, String time,Integer num,Object area,Object handleunit) {
        Result result = new Result();
        result.setData(object);
        result.setSuccess(true);
        result.setMsg("成功");
        result.setTime(time);
        result.setNum(num);
        result.setArea(area);
        result.setHandleunit(handleunit);
        return result;
    }
}
