package com.ltsk.whcg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ltsk.whcg.listener.WarningListListener;
import com.ltsk.whcg.service.WarningListService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;

import io.vertx.core.cli.annotations.DefaultValue;

/*
 * 燃气警告指数统计,燃气设备监控
 */
@RestController
public class GasWaringListController {
	

	@Autowired
	private WarningListService warningListService;

	@RequestMapping("/getWarning")
	public Result getWarning(@RequestParam(value = "xzqh") String xzqh) {
		if("420100000000".equals(xzqh)){
			if(WarningListListener.warningList!=null){
				return ResultUtils.success(WarningListListener.warningList);
			}
			return ResultUtils.success(warningListService.getWarning(xzqh));
		}else{
			return ResultUtils.success(warningListService.getWarnByXzqh(xzqh));
		}

	}

	@RequestMapping("/getEqDevice")
	public Result getEqDevice(@RequestParam(value = "xzqh") String xzqh) {

		return ResultUtils.success(warningListService.getEqDevice(xzqh));
	}

}
