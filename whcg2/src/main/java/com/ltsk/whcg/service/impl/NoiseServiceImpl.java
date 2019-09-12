package com.ltsk.whcg.service.impl;


import com.ltsk.whcg.service.NoiseService;

import lombok.extern.slf4j.Slf4j;

import com.ltsk.whcg.digital.mapper.NoiseMapper;
import com.ltsk.whcg.entity.NoiseAndBuilding;
import com.ltsk.whcg.listener.XZQHListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class NoiseServiceImpl implements NoiseService{

    @Autowired
    private NoiseMapper noiseMapper;

    @Override
    public List<NoiseAndBuilding>  getAllNoise(String xzqh) {
    	try{
    		 Map<String,String> map  = XZQHListener.XZQHMap;
             xzqh = map.get(xzqh);
             if("全市".equals(xzqh)){
            	 xzqh=null;
             }
            return noiseMapper.getAll(xzqh);
    	}catch(Exception e){
    		log.error("获得所有施工扰民失败");
    		return new ArrayList<>();
    	}
    }
}
