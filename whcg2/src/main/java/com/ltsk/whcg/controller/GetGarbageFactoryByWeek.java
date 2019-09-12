package com.ltsk.whcg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ltsk.whcg.service.HouseholdGarbageFactoryService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;

/**
 * 生活垃圾处理厂一周处理量 (前7天)
 * @author Administrator
 *
 */
@RestController
public class GetGarbageFactoryByWeek {

	@Autowired
	private HouseholdGarbageFactoryService householdGarbageFactoryService;

	@RequestMapping("/garbageFactoryByWeek")
	public Result getAll(@RequestParam(value="xzqh",defaultValue="420100000000")String xzqh) {
		return ResultUtils.success(householdGarbageFactoryService.getLastWeek(xzqh));
	}
	
	
}
