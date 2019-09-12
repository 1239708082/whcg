package com.ltsk.whcg.service.impl;

import com.ltsk.whcg.service.SuspicSiteUnloadService;
import com.ltsk.whcg.utils.PositionUtil;

import lombok.extern.slf4j.Slf4j;

import com.ltsk.whcg.base.mapper.SuspicSiteUnloadMapper;
import com.ltsk.whcg.entity.Gps;
import com.ltsk.whcg.entity.Suspicsiteunload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SuspicSiteUnloadServiceImpl implements SuspicSiteUnloadService {

    private static final String NAME = "湖北省武汉市";

    @Autowired
    private SuspicSiteUnloadMapper suspicSiteUnloadMapper;

    @Override
    public List<Suspicsiteunload> getAllByType(String type, String xzqh) {
        try {
            xzqh = NAME + xzqh + "%";
            List<Suspicsiteunload> all = suspicSiteUnloadMapper.getAll(type, xzqh);
            if(all.size()<1)
            	return new ArrayList<>();
//            for (Suspicsiteunload suspicsiteunload : all) {
//				Gps xy84 = PositionUtil.gcj_To_Gps84(suspicsiteunload.getGdy(), suspicsiteunload.getGdx());
//				suspicsiteunload.setGdx(xy84.getWgLon());
//				suspicsiteunload.setGdy(xy84.getWgLat());
//            }
            return all;
        } catch (Exception e) {
            log.error("获得可疑工地消纳点失败");
            return new ArrayList<>();
        }
    }
}
