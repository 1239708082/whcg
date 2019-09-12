package com.ltsk.whcg.service.impl;

import com.ltsk.whcg.service.SiteService;
import com.ltsk.whcg.utils.PositionUtil;

import lombok.extern.slf4j.Slf4j;

import com.ltsk.whcg.base.mapper.SiteMapper;
import com.ltsk.whcg.entity.Gps;
import com.ltsk.whcg.entity.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SiteServiceImpl implements SiteService{

    @Autowired
    private SiteMapper siteMapper;

    @Override
    public List<Site> getAll() {
    	try{
    		List<Site> all = siteMapper.getAll();
    		if(all.size()<1)
    			return new ArrayList<>();
//    		for (Site site : all) {
//				Gps xy84 = PositionUtil.gcj_To_Gps84(site.getGdy(), site.getGdx());
//				site.setGdx(xy84.getWgLon());
//				site.setGdy(xy84.getWgLat());
//    		}
            return all;
    	}catch(Exception e){
    		log.error("获得所有工地失败");
    		return new ArrayList<>();
    	}
    }
}
