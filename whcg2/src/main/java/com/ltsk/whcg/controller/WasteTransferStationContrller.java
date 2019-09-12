/**
 * 
 */
package com.ltsk.whcg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ltsk.whcg.service.WasteTransferStationService;
import com.ltsk.whcg.utils.Result;

import net.sf.json.JSONObject;

/**
 * @author YH
 * @ClassName: WasteTransferStationContrller 
 * @Description
 * @date 2019年7月30日 下午5:37:24 
 */
@RestController
public class WasteTransferStationContrller {
	

    @Autowired
    private WasteTransferStationService wTSS;

    @RequestMapping("listWasteTransferStationInfo")
	public Result listWasteTransferStationInfo(@RequestParam(value = "xzqh", defaultValue = "420100000000") String xzqh) {
		 return wTSS.listWasteTransferStationInfo(xzqh);
	}
}
