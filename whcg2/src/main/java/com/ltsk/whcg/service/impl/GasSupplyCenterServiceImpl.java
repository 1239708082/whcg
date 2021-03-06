package com.ltsk.whcg.service.impl;

import com.ltsk.whcg.service.GasSupplyCenterService;
import com.ltsk.whcg.utils.PositionUtil;

import lombok.extern.slf4j.Slf4j;

import com.ltsk.whcg.base.mapper.GasSupplyCenterMapper;
import com.ltsk.whcg.entity.GasSite;
import com.ltsk.whcg.entity.GasSiteNew;
import com.ltsk.whcg.entity.Gps;
import com.ltsk.whcg.listener.XZQHListener;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class GasSupplyCenterServiceImpl implements GasSupplyCenterService {

	@Autowired
	private GasSupplyCenterMapper gasSupplyCenterMapper;

	@Override
	public List<GasSiteNew> getAll(String xzqh) {
		try {
			Map<String, String> map = XZQHListener.XZQHMap;
			xzqh = map.get(xzqh);
			if ("全市".equals(xzqh)) {
				xzqh = null;
			}
			if("武汉经济技术开发区".equals(xzqh))
				xzqh="武汉经济开发";
    		if("武汉东湖新技术开发区".equals(xzqh))
    			xzqh="东湖高新区";
    		if("东湖生态旅游风景区管委会".equals(xzqh))
    			xzqh="东湖风景区";
			List<GasSite> list = gasSupplyCenterMapper.getAll(xzqh);
			if(list.size()<1)
     			return new ArrayList<>();
			List<GasSiteNew> result = new ArrayList<GasSiteNew>();
			list.forEach(e -> {
				GasSiteNew c = new GasSiteNew();
				BeanUtils.copyProperties(e, c);
				String[] xy = e.getXy().split(",");
//				Gps xy84 = PositionUtil.gcj_To_Gps84(Double.parseDouble(xy[0]), Double.parseDouble(xy[1]));
//				c.setGdx(xy84.getWgLon());
//				c.setGdy(xy84.getWgLat());
				c.setGdx(Double.parseDouble(xy[0]));
				c.setGdy(Double.parseDouble(xy[1]));
				result.add(c);
			});
			return result;
		} catch (Exception e) {
			log.error("瓶装气供应点信息查询失败!!");
			return new ArrayList<>();
		}
	}

	@Override
	public Integer getSum() {
		return gasSupplyCenterMapper.getSum();
	}
}
