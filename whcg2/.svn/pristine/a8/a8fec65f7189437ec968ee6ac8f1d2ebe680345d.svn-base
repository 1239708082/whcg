package com.ltsk.whcg.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsk.whcg.base.mapper.GdMapper;
import com.ltsk.whcg.entity.GdInfo;
import com.ltsk.whcg.entity.Gps;
import com.ltsk.whcg.listener.XZQHListener;
import com.ltsk.whcg.service.GdService;
import com.ltsk.whcg.utils.PositionUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GdServiceImpl implements GdService {

	@Autowired
	private GdMapper gdMapper;

	@Override
	public List<GdInfo> getAllGd(String xzqh) {
		try {
			xzqh = XZQHListener.XZQHMap.get(xzqh);
			List<GdInfo> list = new ArrayList<>();
			if ("全市".equals(xzqh) || "市辖".equals(xzqh)) {
				list = gdMapper.getAll(null);
			} else {
				list = gdMapper.getAll("湖北省武汉市%" + xzqh + "%");
			}
			if(list.size()<1)
     			return new ArrayList<>();
			for (GdInfo gdInfo : list) {
				List strs= new ArrayList();
				gdInfo.setXys(strs);
				String [] xs = gdInfo.getMapx().split(",");
				String [] ys = gdInfo.getMapy().split(",");
				for (int i = 0; i < ys.length; i++) {
					Gps xy84 = PositionUtil.gcj_To_Gps84(Double.parseDouble(ys[i]), Double.parseDouble(xs[i]));
					List newList = new ArrayList();
					newList.add(xy84.getWgLon());
					newList.add(xy84.getWgLat());
					gdInfo.getXys().add(newList);
				}
			}
			return list;
		} catch (Exception e) {
			log.info("工地信息查询失败");
			return new ArrayList<>();
		}

	}

}
