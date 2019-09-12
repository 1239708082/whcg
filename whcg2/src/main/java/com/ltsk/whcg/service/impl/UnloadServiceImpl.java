package com.ltsk.whcg.service.impl;

import com.ltsk.whcg.service.UnloadService;
import com.ltsk.whcg.utils.PositionUtil;

import lombok.extern.slf4j.Slf4j;

import com.ltsk.whcg.base.mapper.UnloadMapper;
import com.ltsk.whcg.entity.Gps;
import com.ltsk.whcg.entity.Unload;
import com.ltsk.whcg.entity.Zhqtxnd;
import com.ltsk.whcg.listener.XZQHListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UnloadServiceImpl implements UnloadService {

	@Autowired
	private UnloadMapper unloadMapper;

	@Override
	public List<Unload> getAll() {
		try {
			List<Unload > list = unloadMapper.getAll();
			//高德转84  换回高德.
//			if(list!=null){
//				for (Unload unload : list) {
//					Double x= unload.getGdx();
//					Double y = unload.getGdy();
//					unload.setGdx(PositionUtil.gcj_To_Gps84(y,x).getWgLon());
//					unload.setGdy(PositionUtil.gcj_To_Gps84(y,x).getWgLat());
//				}
//			}
			
			return list;
		} catch (Exception e) {
			log.error("获得所有消纳点失败");
			return new ArrayList<>();
		}
	}

	@Override
	public List<Zhqtxnd> getXnd(String xzqh) {
		try {
			String xzqh_str = XZQHListener.XZQHMap.get(xzqh);

			List<Zhqtxnd> xnd = new ArrayList<>();
			if ("武汉经济技术开发区".equals(xzqh_str))
				xzqh_str = "经济开发区";
			if ("全市".equals(xzqh_str)) {
				xnd = unloadMapper.getXnd(null);
			} else {
				xnd = unloadMapper.getXnd("%" + xzqh_str + "%");
			}
			String x = "";
			String y = "";
			Double lon = 0.0;
			Double lat = 0.0;
			Gps g = new Gps();
			if(xnd!=null){
				for (Zhqtxnd zhqtxnd : xnd) {
					List xy_list = new ArrayList();
					for (int i = 0; i < zhqtxnd.getMapx().split(",").length; i++) {
						List<Double> xy = new ArrayList<>();
						x = zhqtxnd.getMapx().split(",")[i];
						y = zhqtxnd.getMapy().split(",")[i];
						lon = Double.parseDouble(x);
						lat  = Double.parseDouble(y);
//						g = PositionUtil.gcj_To_Gps84(lat, lon);
//						xy.add(g.getWgLon());
//						xy.add(g.getWgLat());;
						xy.add(lon);
						xy.add(lat);
						xy_list.add(xy);
					}
					zhqtxnd.setXy(xy_list);
				}
			}
			return xnd;
		} catch (Exception e) {
			log.error("获得所有消纳点失败");
			return new ArrayList<>();
		}
	}
}
