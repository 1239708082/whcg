package com.ltsk.whcg.controller;

import com.ltsk.whcg.listener.LawListener;
import com.ltsk.whcg.service.BuildingService;
import com.ltsk.whcg.service.NoiseService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.entity.NoiseAndBuilding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 执法主题初始化
 */
@RestController
public class LawController {

    @Autowired
    private NoiseService noiseService;

    @Autowired
    private BuildingService buildingService;

    @RequestMapping("law")
    public Result init() {
        List<Map<String,Object>> lawInit = LawListener.lawInit;
        return ResultUtils.success(lawInit);

    }
}

