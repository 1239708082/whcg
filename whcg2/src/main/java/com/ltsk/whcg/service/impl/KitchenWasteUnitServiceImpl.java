package com.ltsk.whcg.service.impl;

import com.ltsk.whcg.service.KitchenWasteUnitService;
import com.ltsk.whcg.utils.PositionUtil;

import lombok.extern.slf4j.Slf4j;

import com.ltsk.whcg.base.mapper.KitchenWasteUnitMapper;
import com.ltsk.whcg.entity.Ccljcydw;
import com.ltsk.whcg.entity.CcljcydwNew;
import com.ltsk.whcg.entity.Gps;
import com.ltsk.whcg.listener.XZQHListener;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class KitchenWasteUnitServiceImpl implements KitchenWasteUnitService {

    @Autowired
    private KitchenWasteUnitMapper kitchenWasteUnitMapper;
    @Override
    public List<CcljcydwNew> getAll(String xzqh) {
    	String xzqh_name=XZQHListener.XZQHMap.get(xzqh);
    	try{
    		if("武汉经济技术开发区".equals(xzqh_name))
    			xzqh_name="开发区";
			if("武汉东湖新技术开发区".equals(xzqh_name))
				xzqh_name="高新区";
			if("东湖生态旅游风景区管委会".equals(xzqh_name))
				xzqh_name="东湖风景区";
    		if("全市".equals(xzqh_name)){
    			xzqh_name=null;
    		}
    		List<Ccljcydw> list = kitchenWasteUnitMapper.getAll(xzqh_name);
    		if(list.size()<1)
    			return new ArrayList<>();
            List<CcljcydwNew> result = new ArrayList<CcljcydwNew>();
            list.forEach(e->{
                CcljcydwNew c = new CcljcydwNew();
                BeanUtils.copyProperties(e,c);
                String [] xy = e.getXy().split(",");
//                Gps xy84 = PositionUtil.gcj_To_Gps84(Double.parseDouble(xy[1]), Double.parseDouble(xy[0]));
                c.setGdx(Double.parseDouble(xy[0]));
                c.setGdy(Double.parseDouble(xy[1]));
                result.add(c);
            });
            return result;
    	}catch(Exception e){
    		e.printStackTrace();
    		log.error("获得餐厨单位失败");
    		return new ArrayList<>();
    	}
        
    }
}
