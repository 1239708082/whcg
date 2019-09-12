package com.ltsk.whcg.service.impl;

import com.ltsk.whcg.service.GasCompanyService;
import com.ltsk.whcg.utils.PositionUtil;

import lombok.extern.slf4j.Slf4j;

import com.ltsk.whcg.base.mapper.GasCompanyMapper;
import com.ltsk.whcg.entity.Gascompany;
import com.ltsk.whcg.entity.Gps;
import com.ltsk.whcg.listener.XZQHListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class GasCompanyServiceImpl implements GasCompanyService{

    @Autowired
    private GasCompanyMapper gasCompanyMapper;

    @Override
    public List<Gascompany> getAll(String xzqh) {
        try {
        	  Map<String,String> map  = XZQHListener.XZQHMap;
              xzqh = map.get(xzqh);
              if("全市".equals(xzqh)){
             	 xzqh=null;
              }
              List<Gascompany> all = gasCompanyMapper.getAll(xzqh);
              if(all.size()<1)
       			return new ArrayList<>();
//              for (Gascompany gascompany : all) {
//				Gps xy84 = PositionUtil.gcj_To_Gps84(Double.parseDouble(gascompany.getLatitude()), Double.parseDouble(gascompany.getLongitude()));
//				gascompany.setLatitude(xy84.getWgLat()+"");
//				gascompany.setLongitude(xy84.getWgLon()+"");
//			}
			return all;
		} catch (Exception e) {
			log.error("燃气企业信息查询失败!!");
			return new ArrayList<>();
		}
    }

	@Override
	public Integer getSum() {
		return gasCompanyMapper.getSum();
	}
}
