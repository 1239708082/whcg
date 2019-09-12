package com.ltsk.whcg.service.impl;

import com.ltsk.whcg.service.BuildingService;

import lombok.extern.slf4j.Slf4j;

import com.ltsk.whcg.digital.mapper.BuildingMapper;
import com.ltsk.whcg.entity.NoiseAndBuilding;
import com.ltsk.whcg.listener.XZQHListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingMapper buildingMapper;

	@Override
	public List<NoiseAndBuilding> getAllBuilding(String xzqh) {
		try {
			
			 Map<String,String> map  = XZQHListener.XZQHMap;
             xzqh = map.get(xzqh);
             
             if("全市".equals(xzqh)){
            	 xzqh=null;
             }
			return buildingMapper.getAll(xzqh);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("私搭乱建信息查询失败!!");

			return new ArrayList<>();
		}
	}
}
