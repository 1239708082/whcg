package com.ltsk.whcg.controller;

import com.ltsk.whcg.service.FumeUnitService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.entity.Cyyycginfo;

import org.apache.catalina.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 餐厨油烟单位
 */
@RestController
public class FumeUnitController {

    @Autowired
    private FumeUnitService fumeUnitService;

    /**
     * 得到所有的餐厨油烟单位
     * @param xzqh
     * @return
     */
    @RequestMapping("/fumeUnit")
    public Result getAll(@RequestParam(value="xzqh",defaultValue="420100000000")String xzqh){
        return ResultUtils.success(fumeUnitService.getAll(xzqh));
    }
    /**
     * 最近7天餐厨油烟报警最多的单位.
     * @return
     */
    @RequestMapping("/getMostfu")
    public Result getAll(){
        return ResultUtils.success(fumeUnitService.getMostCyyydw());
    }
}
