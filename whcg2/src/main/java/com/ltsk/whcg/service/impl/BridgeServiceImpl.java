package com.ltsk.whcg.service.impl;

import com.ltsk.whcg.service.BridgeService;
import com.ltsk.whcg.utils.PositionUtil;
import com.ltsk.whcg.base.mapper.BridgeMapper;
import com.ltsk.whcg.entity.Bridge;
import com.ltsk.whcg.entity.BridgeVideo;
import com.ltsk.whcg.entity.Gps;
import com.ltsk.whcg.listener.XZQHListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BridgeServiceImpl implements BridgeService{

    @Autowired
    private BridgeMapper bridgeMapper;

    @Override
    public List<Bridge> getAll() {
        try {
        	List<Bridge> bridgeList = bridgeMapper.getAll();
        	if(bridgeList.size()<1)
    			return new ArrayList<>();
//        	for (Bridge bridge : bridgeList) {
//				Gps xy84 = PositionUtil.gcj_To_Gps84(bridge.getGdy(), bridge.getGdx());
//				bridge.setGdx(xy84.getWgLon());
//				bridge.setGdy(xy84.getWgLat());
//        	}
            return bridgeList;
        }catch (Exception e ){
            log.error("桥梁信息查询失败！！");
            return new ArrayList<>();
        }

    }

	@Override
	public List<BridgeVideo> getVideo() {
		
		
		 try {
		      	List<BridgeVideo > list = bridgeMapper.getVideo();
		      	for (BridgeVideo b : list) {
//		      		Gps xy84 = PositionUtil.gcj_To_Gps84(Double.parseDouble(b.getGdxy().split(",")[1]), Double.parseDouble(b.getGdxy().split(",")[0]));
//					b.setGdxy(xy84.getWgLon()+","+xy84.getWgLat());
//		      		b.setGdx(xy84.getWgLon()+"");
//		      		b.setGdy(xy84.getWgLat()+"");
					b.setGdx(b.getGdxy().split(",")[0]);
		      		b.setGdy(b.getGdxy().split(",")[1]);
				}
	            return list;
	        }catch (Exception e ){
	        	e.printStackTrace();
	            log.error("桥梁视频信息查询失败！！");
	            return new ArrayList<>();
	        }
	}
}
