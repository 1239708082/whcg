package com.ltsk.whcg.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsk.whcg.service.GasBusinessPointService;
import com.ltsk.whcg.service.GasCompanyService;
import com.ltsk.whcg.service.GasStationService;
import com.ltsk.whcg.service.GasSumService;
import com.ltsk.whcg.service.GasSupplyCenterService;

import lombok.extern.slf4j.Slf4j;

import javax.lang.model.element.VariableElement;

@Service
@Slf4j
public class GasSumServiceImpl implements GasSumService{
	@Autowired
	private GasSupplyCenterService gscs;//瓶装气供应点条数
	@Autowired
	private GasStationService gss;//储备站 ，加气站，门站
	@Autowired
	private GasBusinessPointService gbps;//营业网点
	@Autowired
	private GasCompanyService gcs;//燃气企业
	@Override
	public Map<String, Integer> result() {
		try {
			Map<String, Integer> result=new HashMap<>();
			result.put("供应点", gscs.getSum());
			result.put("储配站", gss.getSum("储配站"));
			result.put("加气站", gss.getSum("加气站"));
			result.put("门站", gss.getSum("门站"));
			result.put("营业网点", gbps.getSum());
			result.put("燃气企业", gcs.getSum());
			return result;
		} catch (Exception e) {
			log.error("获得燃气热力总条数失败");
			return new HashMap<>();
		}
		
	}

}
