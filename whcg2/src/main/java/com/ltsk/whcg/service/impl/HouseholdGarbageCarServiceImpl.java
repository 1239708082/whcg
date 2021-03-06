package com.ltsk.whcg.service.impl;

import com.ltsk.whcg.service.HouseholdGarbageCarService;
import com.ltsk.whcg.utils.PositionUtil;

import lombok.extern.slf4j.Slf4j;

import com.ltsk.whcg.base.mapper.HouseholdGarbageCarMapper;
import com.ltsk.whcg.entity.GfclRealtime;
import com.ltsk.whcg.entity.Gps;
import com.ltsk.whcg.listener.XZQHListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class HouseholdGarbageCarServiceImpl implements HouseholdGarbageCarService {

    @Autowired
    private HouseholdGarbageCarMapper householdGarbageCarMapper;
    @Override
    public Map<String, Object> getHouseholdGarbageFactoryCar(String xzqh) {
        try {
			Map<String, Object> map = new HashMap<String,Object>();
			 xzqh =  XZQHListener.XZQHMap.get(xzqh);
             if("武汉经济技术开发区".equals(xzqh))
            	 xzqh="武汉开发区";
             if("武汉东湖新技术开发区".equals(xzqh))
            	 xzqh="东湖开发区";
             if("东湖生态旅游风景区管委会".equals(xzqh))
            	 xzqh="东湖风景区";
             if("全市".equals(xzqh)){
            	 xzqh=null;
             }
			Integer num = householdGarbageCarMapper.count(xzqh);
			List<GfclRealtime> data = householdGarbageCarMapper.getAllRealtime("离线",xzqh);
//			if(data.size()>0){
//				for (GfclRealtime gfclRealtime : data) {
//					Gps xy84 = PositionUtil.gcj_To_Gps84(Double.parseDouble(gfclRealtime.getLatitudedone()+""), Double.parseDouble(gfclRealtime.getLongitudedone()+""));
//					gfclRealtime.setLatitudedone(xy84.getWgLat());
//					gfclRealtime.setLongitudedone(xy84.getWgLon());
//				}
//			}
			map.put("sum",num);
			map.put("data",data);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("生活垃圾车信息查询失败!!");
			return new HashMap<String,Object>();
		}
    }
}
