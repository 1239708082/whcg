package com.ltsk.whcg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltsk.whcg.service.BridgeXzqhService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;

@RestController
public class BridgeXzqhController {
	@Autowired
	private BridgeXzqhService b;
	@RequestMapping("/getBridgeXzqh")
	public Result getAll(String xzqh){
		return ResultUtils.success(b.getAll(xzqh));
	}
}
