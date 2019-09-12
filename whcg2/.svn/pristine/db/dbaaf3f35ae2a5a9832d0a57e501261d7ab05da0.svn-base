package com.ltsk.whcg.controller;

import com.ltsk.whcg.service.BuildingService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.entity.NoiseAndBuilding;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 私搭乱建
 */
@RestController
public class BuildingController {

    @Autowired
    private BuildingService buildingService;


    @RequestMapping("/building")
    public Result getAllBuilding(@RequestParam(value="xzqh") String xzqh) {
        return ResultUtils.success(buildingService.getAllBuilding(xzqh));
    }
}
