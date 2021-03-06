package com.ltsk.whcg.service.impl;

import com.ltsk.whcg.service.MuckService;
import com.ltsk.whcg.utils.DateTime;
import com.ltsk.whcg.utils.PositionUtil;

import lombok.extern.slf4j.Slf4j;

import com.ltsk.whcg.base.mapper.MuckMapper;
import com.ltsk.whcg.entity.Gps;
import com.ltsk.whcg.entity.Muck;
import com.ltsk.whcg.entity.MuckTrace;
import com.ltsk.whcg.listener.XZQHListener;
import com.ltsk.whcg.muck.mapper.MuckTrackMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Service
@Slf4j
public class MuckServiceImpl implements MuckService{

    @Autowired
    private MuckMapper muckMapper;
    
    @Autowired
    private MuckTrackMapper trackMapper;

    @Override
    public List<Muck> getAll(String xzqh) {
    	
    	  Map<String,String> map  = XZQHListener.XZQHMap;
          xzqh = map.get(xzqh);
          if("全市".equals(xzqh)){
        	  return muckMapper.getAll("%武汉市%");
           }else if("东湖生态旅游风景区管委会".equals(xzqh)){
         	  xzqh="东湖风景区";
           }else if("武汉经济技术开发区".equals(xzqh)){
        	   xzqh="经济开发区";
           }else if("武汉东湖新技术开发区".equals(xzqh)){
        	   xzqh="东湖高新区";
           }
    	try{
    		List<Muck> all = muckMapper.getAll("%"+xzqh+"%");
    		if(all.size()<1)
				return new ArrayList<>();
//    		for (Muck muck : all) {
//				Gps xy84 = PositionUtil.gcj_To_Gps84(Double.parseDouble(muck.getGdy()), Double.parseDouble(muck.getGdx()));
//				muck.setGdx(xy84.getWgLon()+"");
//				muck.setGdy(xy84.getWgLat()+"");
//    		}
            return all;
    	}catch(Exception e){
    		log.error("获得渣土车失败");
    		return new ArrayList<>();
    	}
    }

	@Override
	public Integer get_sum(String xzqh) {
		try{
		  Map<String,String> map  = XZQHListener.XZQHMap;
          xzqh = map.get(xzqh);
          if("全市".equals(xzqh)){
        	  return muckMapper.get_sum("%武汉市%");
            }else if("东湖生态旅游风景区管委会".equals(xzqh)){
          	  xzqh="东湖风景区";
            }else if("武汉经济技术开发区".equals(xzqh)){
         	   xzqh="经济开发区";
            }else if("武汉东湖新技术开发区".equals(xzqh)){
         	   xzqh="东湖高新区";
            }
		
			return muckMapper.get_sum("%"+xzqh+"%");
		}catch (Exception e) {
			log.error("获得渣土车总数量失败！！");
			return null;
		}
	}
	

	@Override
	public List<Double[]> getTrace(String vehicleno) {
		
		String tableName =  "MUCK_GPS_HISTORY_"+DateTime.getTableTime();
		
		List<MuckTrace> list = trackMapper.getTrace(tableName, vehicleno);
		List<MuckTrace> result = new ArrayList<>();
		List<Double []> lists = new ArrayList<Double[]>();

		
		for (MuckTrace muckTrace : list) {
			Double [] ss = {muckTrace.getGdx(),muckTrace.getGdy()};
			lists.add(ss);
		}
		
		return lists;
	}
}
