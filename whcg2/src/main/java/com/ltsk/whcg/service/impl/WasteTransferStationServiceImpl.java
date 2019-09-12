/**
 * 
 */
package com.ltsk.whcg.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsk.whcg.base.mapper.WasteTransferStationMapper;
import com.ltsk.whcg.entity.User;
import com.ltsk.whcg.entity.WasteTransferStation;
import com.ltsk.whcg.listener.XZQHListener;
import com.ltsk.whcg.service.WasteTransferStationService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.zhjg.mapper.UserMapper;

/**
 * @author YH
 * @ClassName: WasteTransferStationServiceImpl 
 * @Description
 * @date 2019年7月30日 下午5:41:53 
 */
@Service
public class WasteTransferStationServiceImpl implements WasteTransferStationService{

	@Autowired
	WasteTransferStationMapper wTSM;
	
	@Override
	public Result listWasteTransferStationInfo(String xzqh) {
		
	    List<WasteTransferStation>  list = new ArrayList<WasteTransferStation>();
	    List<WasteTransferStation>  listResult = new ArrayList<WasteTransferStation>();
		if ("420100000000".equals(xzqh)) {
			list = wTSM.listWasteTransferStationInfo();
		} else {
			String xzqhCN = XZQHListener.XZQHMap.get(xzqh);
			list = wTSM.listWasteTransferStationInfoByXzqh(xzqhCN);
		}
		
		for (WasteTransferStation w : list) {
			String gdxy = w.getGDXY();
			String[] split = gdxy.split(",");
			w.setGDX(split[0]);
			w.setGDY(split[1]);
			listResult.add(w);
		}
		return ResultUtils.success(listResult);
	}

}
