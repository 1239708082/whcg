package com.ltsk.whcg.service.impl;

import com.ltsk.whcg.service.GasBusinessPointService;
import com.ltsk.whcg.utils.PositionUtil;

import lombok.extern.slf4j.Slf4j;

import com.ltsk.whcg.base.mapper.GasBusinessPointMapper;
import com.ltsk.whcg.entity.Gasbusinesspoint;
import com.ltsk.whcg.entity.Gps;
import com.ltsk.whcg.listener.XZQHListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class GasBusinessPointServiceImpl implements GasBusinessPointService{

    @Autowired
    private GasBusinessPointMapper gasBusinessPointMapper;

    @Override
    public List<Gasbusinesspoint> getAll(String xzqh) {
        try {
        	 Map<String,String> map  = XZQHListener.XZQHMap;
             xzqh = map.get(xzqh);
             if("全市".equals(xzqh)){
            	 xzqh=null;
             }
             List<Gasbusinesspoint> all = gasBusinessPointMapper.getAll(xzqh);
             if(all.size()<1)
     			return new ArrayList<>();
//             for (Gasbusinesspoint gasbusinesspoint : all) {
//				Gps xy84 = PositionUtil.gcj_To_Gps84(Double.parseDouble(gasbusinesspoint.getLatitude()), Double.parseDouble(gasbusinesspoint.getLongitude()));
//				gasbusinesspoint.setLatitude(xy84.getWgLat()+"");
//				gasbusinesspoint.setLongitude(xy84.getWgLon()+"");
//			}
             return all;
		} catch (Exception e) {
			log.error("燃气营业网点信息查询失败!!");
			return new ArrayList<>();
		}
    }

	@Override
	public Integer getSum() {
		return gasBusinessPointMapper.getSum();
	}
}
