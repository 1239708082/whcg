package com.ltsk.whcg.controller;

import com.ltsk.whcg.service.BridgeService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 桥梁
 */
@RestController
public class BridgeController {

	@Autowired
	private BridgeService bridgeService;

	@RequestMapping("/bridge")
	public Result getAll() {
		return ResultUtils.success(bridgeService.getAll());
	}

	@RequestMapping("/bridgeVideo")
	public Result getAllVideo() {
		return ResultUtils.success(bridgeService.getVideo());
	}
}
