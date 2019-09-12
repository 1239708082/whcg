package com.ltsk.whcg.service;

import com.ltsk.whcg.entity.BridgeDefectRecord;

import java.util.List;
import java.util.Map;

public interface BridgeDefectRecordService {
	//获得当日桥隧信息
    List<BridgeDefectRecord> getAll();
    //获得桥隧病害数分行政区划
    List<Map<String, Object>> getBridgeDefectSumGroupXzqh(String xzqh);
    //获得桥隧病害总数
    Integer getBridgeDefectSum();
    //获得前10桥隧病害数
    List<Map<String, Object>> getBridgeDefectSumGroupName(String xzqh);
    //获得各种处理状态下的病害数量
    List<Map<String, Object>> getBridgeDefectNumGroupStatus();
    //获得每个管理单位管理的桥隧数
    List<Map<String, Object>> getBridgeDefectNumGroupUnit();
    //按桥梁类型分组统计数量
    List<Map<String, Integer>> getgetBridgeNumGroupBuildkind();
    //按桥隧大小型号分组统计数量
    List<Map<String, Integer>> getBridgeNumGroupBuildsize();
}
