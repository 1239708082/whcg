package com.ltsk.whcg.controller;

import com.ltsk.whcg.service.GasBusinessPointService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.entity.Gasbusinesspoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * 营业网点
 *
 */
@RestController
public class GasBusinessPointController {

    @Autowired
    private GasBusinessPointService gasBusinessPointService;

    @RequestMapping("/gasBusinessPoint")
    public Result getAll(@RequestParam(value="xzqh") String xzqh){
        return ResultUtils.success(gasBusinessPointService.getAll( xzqh));
    }
}
