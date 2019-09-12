package com.ltsk.whcg.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltsk.whcg.base.mapper.TrashMapper;
import com.ltsk.whcg.entity.Gps;
import com.ltsk.whcg.entity.Trash;
import com.ltsk.whcg.listener.XZQHListener;
import com.ltsk.whcg.service.TrashService;
import com.ltsk.whcg.utils.PositionUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class TrashServiceImpl implements TrashService {
	@Autowired
	private TrashMapper traMapper;

	@Override
	public List<Trash> getTrash() {
		return traMapper.getTrash();
	}

	@Override
	public int update_trash(String lat, String lon, Integer id) {
		return traMapper.update_trash(lat, lon, id);
	}

	/**
	 * 得到某个行政区划下带84坐标的垃圾桶位置的集合
	 */
	@Override
	public List<Trash> getNewTrash(String xzqh) {
		try {
			Map<String, String> map = XZQHListener.XZQHMap;
			xzqh = map.get(xzqh);
			if ("全市".equals(xzqh)) {
				xzqh = null;
			} else if ("东湖生态旅游风景区管委会".equals(xzqh)) {
				xzqh = "东湖风景区";
			}
			List<Trash> list = traMapper.getNewTrash(xzqh);
			if(list!=null){
				Gps g = new Gps();
				for (Trash trash : list) {
					
					g.setWgLat(Double.parseDouble(trash.getY()));
					g.setWgLon(Double.parseDouble(trash.getX()));
					g= PositionUtil.bd09_To_Gps84(g.getWgLat(), g.getWgLon());
					trash.setGdx(g.getWgLon()+"");
					trash.setGdy(g.getWgLat()+"");
				}
			}
			return list;
		} catch (Exception e) {
			log.error("垃圾桶信息查询失败!!");
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
}
