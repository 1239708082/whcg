package com.ltsk.whcg.service.impl;

/**
 * @author zd
 * 环卫界面餐厨垃圾处理量数据
 * */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsk.whcg.base.mapper.GetCcljWeightMapper;
import com.ltsk.whcg.entity.Ccljtoday;
import com.ltsk.whcg.entity.GetCcljWeight;
import com.ltsk.whcg.listener.XZQHListener;
import com.ltsk.whcg.service.GetCcljWeightService;
import com.ltsk.whcg.utils.DateTime;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GetCcljWeightServiceImpl implements GetCcljWeightService {
	@Autowired
	private GetCcljWeightMapper getCcljWeightMapper;

	@Override
	public Double getWeight_sum(String xzqh) {
		try {
			if ("武汉经济技术开发区".equals(xzqh))
				xzqh = "武汉开发区";
			if ("武汉东湖新技术开发区".equals(xzqh))
				xzqh = "东湖高新区";
			if ("东湖生态旅游风景区管委会".equals(xzqh))
				xzqh = "东湖风景区";
			if ("全市".equals(xzqh)) {
				xzqh = null;
			}
			return getCcljWeightMapper.getWeight_sum(xzqh);
		} catch (Exception e) {
			log.error("获取垃圾处理总量失败!!!");
			return 0.0;
		}
	}

	// 一周餐厨垃圾处理数据
	@Override
	public List<List<Map<String, Object>>> getWeightWeek(String xzqh) {
		try {
			List<List<Map<String, Object>>> result = new ArrayList<>();
			String xzqh_str = XZQHListener.XZQHMap.get(xzqh);
			if ("武汉经济技术开发区".equals(xzqh_str))
				xzqh_str = "武汉开发区";
			if ("武汉东湖新技术开发区".equals(xzqh_str))
				xzqh_str = "东湖高新区";
			if ("东湖生态旅游风景区管委会".equals(xzqh_str))
				xzqh_str = "东湖风景区";
			if ("全市".equals(xzqh_str)) {//市级7天垃圾处理量
				List<GetCcljWeight> weight_week = getCcljWeightMapper.getWeight();
				if (weight_week.size() < 1)
					return new ArrayList<>();
				Map<String, List<GetCcljWeight>> collect = weight_week.stream()
						.collect(Collectors.groupingBy(GetCcljWeight::getDepname));
				Set<String> keySet = collect.keySet();
				List<List<GetCcljWeight>> list = new ArrayList<>();
				for (String string : keySet) {//分离厂名，剥离厂名对应下的数据，分成集合
					List<GetCcljWeight> list_c = collect.get(string);
					list.add(list_c);
				}
				for (List<GetCcljWeight> list2 : list) {
					List<Map<String, Object>> list1 = new ArrayList<>();
					List<Map<String, Object>> date=new ArrayList<>();
					for (int i = 7; i >0; i--) {//补出7天数据，每个字段给个默认值
						Map<String, Object> map=new HashMap<>();
						map.put("time", DateTime.getPastDate(i).replaceAll("-", "/"));
						map.put("weight", "0.0");
						map.put("depname", "");
						date.add(map);
					}
					for (GetCcljWeight getCcljWeight : list2) {
						for (Map<String, Object> d : date) {
							if(d.get("time").equals(getCcljWeight.getTime())){
								d.put("weight", getCcljWeight.getWeight());
							}
							d.put("depname", getCcljWeight.getDepname());
						}
					}
					result.add(date);
				}
			} else {//区级7天垃圾量
				List<GetCcljWeight> weightByXzqh = getCcljWeightMapper.getWeightByXzqh(xzqh_str);
				if (weightByXzqh.size() < 1) {
					return new ArrayList<>();
				}
				List<Map<String, Object>> list1 = new ArrayList<>();
				for (GetCcljWeight getCcljWeight : weightByXzqh) {
					Map<String, Object> map = new HashMap<>();
					map.put("time", getCcljWeight.getTime().substring(5, 10));
					map.put("weight", getCcljWeight.getWeight());
					map.put("depname", getCcljWeight.getOrgname());
					list1.add(map);
				}
				result.add(list1);
			}
			// 对结果作无数据补0处理
			List<String> w = new ArrayList<>();
			for (int i = 1; i < 8; i++) {
				w.add(DateTime.timeStr2(i));
			}
			List<String> d = new ArrayList<>();
			for (List<Map<String, Object>> r : result) {
				String depname = "";
				for (Map<String, Object> map : r) {
					depname = (String) map.get("depname");
					d.add((String) map.get("time"));
				}
				w.removeAll(d);
				for (String w1 : w) {
					Map<String, Object> maps = new TreeMap<>();
					maps.put("time", w1);
					maps.put("weight", 0.0);
					maps.put("depname", depname);
					r.add(maps);
				}
				// 按时间做排序
				Collections.sort(r, new Comparator<Map<String, Object>>() {
					public int compare(Map<String, Object> o1, Map<String, Object> o2) {
						return o1.get("time").toString().compareTo(o2.get("time").toString());
					}
				});
			}
			return result;
		} catch (Exception e) {
			log.error("获得一周餐厨垃圾处理量失败");
			return new ArrayList<>();
		}
	}

	// 实时餐厨垃圾数据
	@Override
	public List<Map<String, Object>> getWeightNow(String xzqh) {
		try {
			String xzqh_str = XZQHListener.XZQHMap.get(xzqh);
			if ("武汉经济技术开发区".equals(xzqh_str))
				xzqh_str = "武汉开发区";
			if ("武汉东湖新技术开发区".equals(xzqh_str))
				xzqh_str = "东湖高新区";
			if ("东湖生态旅游风景区管委会".equals(xzqh_str))
				xzqh_str = "东湖风景区";
			if ("全市".equals(xzqh_str)) {
				List<GetCcljWeight> wrightOrgname = getCcljWeightMapper.getWrightOrgname();
				if (wrightOrgname.size() < 1)
					return new ArrayList<>();
				List<Map<String, Object>> list = new ArrayList<>();
				for (GetCcljWeight getCcljWeight : wrightOrgname) {
					Map<String, Object> map = new HashMap<>();
					map.put("key", getCcljWeight.getOrgname());
					map.put("weight", getCcljWeight.getWeight());
					list.add(map);
				}
				return list;
			} else {
				List<GetCcljWeight> weightOrgnameByXzqh = getCcljWeightMapper.getWeightOrgnameByXzqh(xzqh_str);
				List<Map<String, Object>> list = new ArrayList<>();
				for (int i = 0; i < 12; i++) {
					Map<String, Object> map = new HashMap<>();
					map.put("key", i * 2 + "~" + (i + 1) * 2);
					map.put("weight", 0.0);
					list.add(map);
				}
				if (weightOrgnameByXzqh.size() < 1)
					return list;

				for (int i = 0; i < weightOrgnameByXzqh.size(); i++) {
					int times = Integer.parseInt(weightOrgnameByXzqh.get(i).getTimes());
					weightOrgnameByXzqh.get(i).setTimes(times* 2 + "~" + (times + 1) * 2);
				}
				for (GetCcljWeight getCcljWeight : weightOrgnameByXzqh) {
					for (Map<String, Object> r : list) {
						if (getCcljWeight.getTimes().equals(r.get("key"))) {
							r.put("weight", getCcljWeight.getWeight());
						}
					}
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("获得实时餐厨垃圾处理量失败");
			return new ArrayList<>();
		}
	}

	@Override
	public List<Ccljtoday> getCcljToday() {
		
		return getCcljWeightMapper.getToday();
	}
}
