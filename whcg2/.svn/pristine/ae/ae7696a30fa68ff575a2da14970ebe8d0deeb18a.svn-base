package com.ltsk.whcg.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsk.whcg.base.mapper.BridgeXzqhMapper;
import com.ltsk.whcg.entity.BridgeXzqh;
import com.ltsk.whcg.listener.XZQHListener;
import com.ltsk.whcg.service.BridgeXzqhService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BridgeXzqhServiceImpl implements BridgeXzqhService{
	
	@Autowired
	private BridgeXzqhMapper b;
	@Override
	public List<BridgeXzqh> getAll(String xzqh) {
		try {
			String xzqh_str = XZQHListener.XZQHMap.get(xzqh);
			if("东湖生态旅游风景区管委会".equals(xzqh_str))
				xzqh_str="东湖风景区";
			if("武汉经济技术开发区".equals(xzqh_str))
				xzqh_str="汉南区";
			if("武汉东湖新技术开发区".equals(xzqh_str))
				xzqh_str="东湖高新区";
			if("全市".equals(xzqh_str))
				xzqh_str=null;
			return b.getAll(xzqh_str);
		} catch (Exception e) {
			log.error("获得桥梁统计数据失败");
			return new ArrayList<>();
		}
	}
	
}
