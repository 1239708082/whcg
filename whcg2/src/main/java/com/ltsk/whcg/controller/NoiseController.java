package com.ltsk.whcg.controller;

import com.ltsk.whcg.service.NoiseService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.entity.NoiseAndBuilding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 施工扰民
 */
@RestController
public class NoiseController {

    @Autowired
    private NoiseService noiseService;

    @RequestMapping("/noise")
    public Result getAllNoise(@RequestParam(value="xzqh") String xzqh){
        return ResultUtils.success(noiseService.getAllNoise(xzqh));
    }

}
