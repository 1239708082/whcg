package com.ltsk.whcg.controller;

import com.ltsk.whcg.service.GasSupplyCenterService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.entity.GasSiteNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
 * 瓶装气供应点
 */
@RestController
public class GasSupplyCenterController {

    @Autowired
    private GasSupplyCenterService gasSupplyCenterService;

    @RequestMapping("gasSupplyCenter")
    public Result getAll(@RequestParam(value="xzqh") String xzqh){
        return ResultUtils.success(gasSupplyCenterService.getAll(xzqh));
    }
}
