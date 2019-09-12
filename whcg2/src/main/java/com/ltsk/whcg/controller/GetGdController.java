package com.ltsk.whcg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ltsk.whcg.service.GdService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;

//查询所有工地的相关信息
@RestController

public class GetGdController {

	
	@Autowired 
	private GdService gdService;
	@RequestMapping("/getGd")
    public Result getAll(@RequestParam(value="xzqh") String xzqh){
        return ResultUtils.success(gdService.getAllGd(xzqh));
    }
	
}
