package com.ltsk.whcg.controller;

import com.ltsk.whcg.service.HouseholdGarbageCarService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 生活垃圾车
 */
@RestController
public class HouseholdGarbageCarController {

	@Autowired
	private HouseholdGarbageCarService householdGarbageCarService;

	@RequestMapping("/householdGarbageCar")
	public Result getHouseholdGarbageFactoryCar(@RequestParam(value="xzqh",defaultValue="420100000000")String xzqh) {
		return ResultUtils.success(householdGarbageCarService.getHouseholdGarbageFactoryCar(xzqh));
	}
}
