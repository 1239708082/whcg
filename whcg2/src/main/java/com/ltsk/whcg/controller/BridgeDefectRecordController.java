package com.ltsk.whcg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltsk.whcg.listener.BridgeDefectListener;
import com.ltsk.whcg.service.BridgeDefectRecordService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;

@RestController
public class BridgeDefectRecordController {
	@Autowired
	private BridgeDefectRecordService bridgeDefectRecordService;

	@RequestMapping("/getBridgeDefectSumGroupXzqh")
	public Result getBridgeDefectSum(String xzqh) {
		return ResultUtils.success(bridgeDefectRecordService.getBridgeDefectSumGroupXzqh(xzqh));
	}

	@RequestMapping("/getBridgeDefectSumGroupName")
	public Result getBridgeDefectSumGroupName(String xzqh) {
		return ResultUtils.success(bridgeDefectRecordService.getBridgeDefectSumGroupName(xzqh));
	}

	@RequestMapping("/getBridgeDefectNumGroupStatus")
	public Result getBridgeDefectNumGroupStatus() {
		return ResultUtils.success(BridgeDefectListener.bridgeDefectNumMap.get("bridgeDefectNumGroupStatus"));
		// return
		// ResultUtils.success(bridgeDefectRecordService.getBridgeDefectNumGroupStatus());
	}

	@RequestMapping("/getBridgeDefectNumGroupUnit")
	public Result getBridgeDefectNumGroupUnit() {
		return ResultUtils.success(BridgeDefectListener.bridgeDefectNumMap.get("bridgeDefectNumGroupUnit"));
		// return
		// ResultUtils.success(bridgeDefectRecordService.getBridgeDefectNumGroupUnit());
	}

	// 按桥梁类型分组统计数据
	@RequestMapping("/getBridgeNumGroupBuildkind")
	public Result getgetBridgeNumGroupBuildkind() {
		return ResultUtils.success(bridgeDefectRecordService.getgetBridgeNumGroupBuildkind());
	}

	// 按桥梁类型分组统计数据
	@RequestMapping("/getBridgeNumGroupBuildsize")
	public Result getBridgeNumGroupBuildsize() {
		return ResultUtils.success(bridgeDefectRecordService.getBridgeNumGroupBuildsize());
	}
}
