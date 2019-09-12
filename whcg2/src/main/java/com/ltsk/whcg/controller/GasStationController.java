package com.ltsk.whcg.controller;

import com.ltsk.whcg.service.GasStationService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.entity.Gasstation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 *  param type
 *  0     门站
 *  1     加气站
 *  2     储配站
 *  3     供应站
 *
 *
 */
@RestController
public class GasStationController {

    @Autowired
    private GasStationService gasStationService;

    @RequestMapping("/gasStation/{type}/{xzqh}")
    public Result getAll(@PathVariable(value = "type") String type ,@PathVariable(value="xzqh") String xzqh){
        return ResultUtils.success(gasStationService.getAll(type,xzqh));
    }
}
