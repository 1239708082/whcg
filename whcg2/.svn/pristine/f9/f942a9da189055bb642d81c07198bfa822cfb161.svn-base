package com.ltsk.whcg.service.impl;

import com.ltsk.whcg.service.BridgeDefectRecordService;

import lombok.extern.slf4j.Slf4j;

import com.ltsk.whcg.bridge.mapper.BridgeDefectRecordMapper;
import com.ltsk.whcg.bridgeDefect.mapper.BridgeDefectMapper;
import com.ltsk.whcg.entity.BridgeDefectRecord;
import com.ltsk.whcg.entity.GetCcljWeight;
import com.ltsk.whcg.listener.XZQHListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@Slf4j
public class BridgeDefectRecordServiceImpl implements BridgeDefectRecordService {

	@Autowired
	private BridgeDefectRecordMapper bridgeDefectRecordMapper;
	@Autowired
	private BridgeDefectMapper bdm;

	@Override
	public List<BridgeDefectRecord> getAll() {
		try {
			return bridgeDefectRecordMapper.getAll();
		} catch (Exception e) {
			log.error("获得桥梁病害失败");
			return new ArrayList<>();
		}
	}

	@Override
	public List<Map<String, Object>> getBridgeDefectSumGroupXzqh(String xzqh) {
		try {
			String xzqh_str = XZQHListener.XZQHMap.get(xzqh);
			List<Map<String, Object>> result = new ArrayList<>();
			if ("全市".equals(xzqh_str)) {
				List<Map<String, Object>> bridgeDefectSum = bridgeDefectRecordMapper.getBridgeDefectSumGroupXzqh();
				if(bridgeDefectSum.size()<1)
					return new ArrayList<>();
				for (Map<String, Object> map : bridgeDefectSum) {
					Map<String, Object> m = new HashMap<>();
					if (map.get("xzqh").equals("江北区") || map.get("xzqh").equals("江南区")
							|| map.get("xzqh").equals("长春-")) {
						continue;
					}
					if ("化学工".equals(map.get("xzqh"))) {
						map.put("xzqh", "化学工业区");
					}
					if ("东湖高".equals(map.get("xzqh"))) {
						map.put("xzqh", "东湖高新区");
					}
					if ("东湖风".equals(map.get("xzqh"))) {
						map.put("xzqh", "东湖风景区");
					}
					if ("东西湖".equals(map.get("xzqh"))) {
						map.put("xzqh", "东西湖区");
					}
					m.put("xzqh", map.get("xzqh"));
					m.put("sum", map.get("sum"));
					result.add(m);
				}
				return result;
			}else{
				if("武汉东湖新技术开发区".equals(xzqh_str))
					xzqh_str="东湖高";
				if("东湖生态旅游风景区管委会".equals(xzqh_str))
					xzqh_str="东湖风";
				if("东西湖区".equals(xzqh_str))
					xzqh_str="东西湖";
				
				List<Map<String, Object>> bridgeDefectNumQJ = bridgeDefectRecordMapper.getBridgeDefectNumQJ(xzqh_str);
				if(bridgeDefectNumQJ.size()<1)
					return new ArrayList<Map<String, Object>>();
				List<Map<String, Object>> list=new ArrayList<>();
				for (int i = 0; i < 12; i++) {
					Map<String, Object> map=new HashMap<>();
					map.put("xzqh", i*2+"~"+(i+1)*2);
					map.put("sum", 0.0);
					list.add(map);
				}
				for (int i = 0; i < bridgeDefectNumQJ.size(); i++) {
					String times = bridgeDefectNumQJ.get(i).get("times").toString();
					times=i*2+"~"+(i+1)*2;
					bridgeDefectNumQJ.get(i).put("times", times);
				}
				for (Map<String, Object> bnum : bridgeDefectNumQJ) {
					for (Map<String, Object> r : list) {
						if (bnum.get("times").equals(r.get("xzqh"))) {
							r.put("sum", bnum.get("num"));
						}
						
					}
				}
				return list;
			}
		} catch (Exception e) {
			log.error("获取区域病害数据失败");
			return new ArrayList<>();
		}

	}

	@Override
	public Integer getBridgeDefectSum() {
		try {
			return bridgeDefectRecordMapper.getBridgeDefectSum();
		} catch (Exception e) {
			log.error("获取总病害数失败");
			return 0;
		}
	}

	@Override
	public List<Map<String, Object>> getBridgeDefectSumGroupName(String xzqh) {
		try {
			String xzqh_str = XZQHListener.XZQHMap.get(xzqh);
			if("武汉东湖新技术开发区".equals(xzqh_str))
				xzqh_str="东湖高";
			if("东湖生态旅游风景区管委会".equals(xzqh_str))
				xzqh_str="东湖风";
			if("东西湖区".equals(xzqh_str))
				xzqh_str="东西湖";
			if("全市".equals(xzqh_str))
				xzqh_str=null;
			return bridgeDefectRecordMapper.getBridgeDefectSumGroupName(xzqh_str);
		} catch (Exception e) {
			log.error("获取桥梁病害数量失败");
			return new ArrayList<>();
		}
	}

	@Override
	public List<Map<String, Object>> getBridgeDefectNumGroupStatus() {
		try {
			List<Map<String, Object>> bridgeDefectNumGroupStatus = bdm.getBridgeDefectNumGroupStatus();
			if(bridgeDefectNumGroupStatus.size()<1){
				return new ArrayList<Map<String, Object>>();
			}
			for (Map<String, Object> map : bridgeDefectNumGroupStatus) {
				String m = map.get("STATE")+"";
				if("0".equals(m))
					map.put("STATE", "当前报警");
				if("1".equals(m))
					map.put("STATE", "未处理");
				if("2".equals(m))
					map.put("STATE", "已处理");
			}
			Map<String, Object> map1 = bridgeDefectNumGroupStatus.get(2);
			Map<String, Object> map2 = bridgeDefectNumGroupStatus.get(1);
			Map<String, Object> map3 = bridgeDefectNumGroupStatus.get(0);
			bridgeDefectNumGroupStatus.removeAll(bridgeDefectNumGroupStatus);
			bridgeDefectNumGroupStatus.add(0, map1);
			bridgeDefectNumGroupStatus.add(1, map3);
			bridgeDefectNumGroupStatus.add(2, map2);
			return bridgeDefectNumGroupStatus;
		} catch (Exception e) {
			log.error("获得各个处理状态下病害数失败！！！");
			return new ArrayList<>();
		}
	}

	@Override
	public List<Map<String, Object>> getBridgeDefectNumGroupUnit() {
		try {
			Map<String, Object> bridgeDefectNumGroupUnit = bdm.getBridgeDefectNumGroupUnit();
			if(bridgeDefectNumGroupUnit.size()<1)
				return new ArrayList<>();
			List<Map<String, Object>> list=new ArrayList<>();
			Set<String> key = bridgeDefectNumGroupUnit.keySet();
			for (String name : key) {
				Map<String, Object> map=new LinkedHashMap<>();
				map.put("STATE", name);
				map.put("NUM", bridgeDefectNumGroupUnit.get(name));
				list.add(map);
			}
			Map<String, Object> map = list.get(1);
			list.remove(1);
			list.add(0, map);
			return list;
		} catch (Exception e) {
			log.error("获得各单位桥梁数失败！！");
			return new ArrayList<>();
		}
	}

	@Override
	public List<Map<String, Integer>> getgetBridgeNumGroupBuildkind() {
		return bdm.getBridgeNumGroupBuildkind();
	}

	@Override
	public List<Map<String, Integer>> getBridgeNumGroupBuildsize() {
		return bdm.getBridgeNumGroupBuildsize();
	}

}
