package com.ltsk.whcg.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltsk.whcg.listener.XZQHListener;
import com.ltsk.whcg.service.GetCcljWeightService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;

/**
 * @author zd
 */
@RestController
public class GetCcljczController {
    @Autowired
    private GetCcljWeightService getCcljWeightService;

    // 获得用户今天餐厨垃圾处理总量分厂
    @RequestMapping("/getCcljToday")
    public Result getWeight_sum() {
        return ResultUtils.success(getCcljWeightService.getCcljToday());
    }

    // 获得用户今天餐厨垃圾处理总量(市级，区级都适用)
    @RequestMapping("/getWeight_sum")
    public Result getWeight_sum(String xzqh) {
        String xzqh_str = XZQHListener.XZQHMap.get(xzqh);
        return ResultUtils.success(getCcljWeightService.getWeight_sum(xzqh_str));
    }

    //	获得一周市级区级餐厨垃圾处理量
    @RequestMapping("/getCcljWeight")
    public Result getWeightWeek_new(String xzqh) {
        return ResultUtils.success(getCcljWeightService.getWeightWeek(xzqh));
    }

    //	获得实时市级区级餐厨垃圾处理量
    @RequestMapping("/getWeightOrgname")
    public Result getWeightNow_new(String xzqh) {
        return ResultUtils.success(getCcljWeightService.getWeightNow(xzqh));
    }
}
