package com.ltsk.whcg.controller;

import com.ltsk.whcg.service.UnloadService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.entity.Unload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 消纳点
 */
@RestController
public class UnloadController {

    @Autowired
    private UnloadService unloadService;

    @RequestMapping("/unload")
    public Result getAll(){
        return ResultUtils.success(unloadService.getAll());
    }
    
    @RequestMapping("/getXnd")
    public Result getXnd(String xzqh){
		return ResultUtils.success(unloadService.getXnd(xzqh));
    }
}
