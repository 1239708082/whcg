package com.ltsk.whcg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltsk.whcg.service.GasSumService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;

@RestController
public class GasSumController {
	@Autowired
	private GasSumService gss;
	@RequestMapping("/getGasSum")
	public Result getGasSum(){
		return ResultUtils.success(gss.result());
	}
}
