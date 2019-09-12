package com.ltsk.whcg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ltsk.whcg.service.FumeUnitService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;

@RestController
public class GetTampblackInfoController {

	@Autowired
	private FumeUnitService fumeUnitService;
//实时油烟报警信息
	@RequestMapping("/getTampblack")
	public Result getAll(@RequestParam(value="xzqh",defaultValue="420100000000")String xzqh) {
		return ResultUtils.success(fumeUnitService.getTampblack(xzqh));
	}
	
}
