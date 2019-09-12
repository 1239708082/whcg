package com.ltsk.whcg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltsk.whcg.service.XZQHService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;

@RestController
public class XZQHController {
	@Autowired
	private XZQHService xzqhService;
	@RequestMapping("/getXZQH")
	public Result getXZQH(){
		return ResultUtils.success(xzqhService.getAll());
	}
}
