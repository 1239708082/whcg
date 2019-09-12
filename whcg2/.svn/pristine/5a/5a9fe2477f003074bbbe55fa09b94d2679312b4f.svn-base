package com.ltsk.whcg.service.impl;

import com.ltsk.whcg.service.FumeUnitService;
import com.ltsk.whcg.utils.DateTime;
import com.ltsk.whcg.utils.PositionUtil;

import lombok.extern.slf4j.Slf4j;

import com.ltsk.whcg.base.mapper.FumeUnitMapper;
import com.ltsk.whcg.entity.Cyyycginfo;
import com.ltsk.whcg.entity.Gps;
import com.ltsk.whcg.entity.LampBlack;
import com.ltsk.whcg.entity.MostFumeUnit;
import com.ltsk.whcg.listener.XZQHListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class FumeUnitServiceImpl implements FumeUnitService {

	@Autowired
	private FumeUnitMapper fumeUnitMapper;

	@Override
	public List<Cyyycginfo> getAll(String xzqh) {
		String xzqh_name = XZQHListener.XZQHMap.get(xzqh);
		try {
			if ("全市".equals(xzqh_name)) {
				xzqh_name = null;
			}
			if ("武汉经济技术开发区".equals(xzqh_name))
				xzqh_name = "经开区";
			if ("武汉东湖新技术开发区".equals(xzqh_name))
				xzqh_name = "东湖高新区";
			if ("东湖生态旅游风景区管委会".equals(xzqh_name))
				xzqh_name = "东湖风景区";
			if ("蔡甸区".equals(xzqh_name))
				xzqh_name = "蔡甸";
			List<Cyyycginfo> all = fumeUnitMapper.getAll(xzqh_name);
			if (all.size() < 1)
				return new ArrayList<>();
			for (Cyyycginfo cyyycginfo : all) {
//				Gps xy84 = PositionUtil.bd09_To_Gps84(Double.parseDouble(cyyycginfo.getLat()),
//						Double.parseDouble(cyyycginfo.getLng()));
//				cyyycginfo.setGdx(xy84.getWgLon() + "");
//				cyyycginfo.setGdy(xy84.getWgLat() + "");
				
				Gps gdxy = PositionUtil.bd09_To_Gcj02(Double.parseDouble(cyyycginfo.getLat()),Double.parseDouble(cyyycginfo.getLng()));
				cyyycginfo.setGdx(gdxy.getWgLon() + "");
				cyyycginfo.setGdy(gdxy.getWgLat() + "");
			
			}
			return all;
		} catch (Exception e) {
			log.error("餐厨油烟单位信息查询失败!!");
			return new ArrayList<>();
		}
	}

	@Override
	public List<LampBlack> getTampblack(String xzqh) {
		
		List<LampBlack> list = new ArrayList<>();
		try {
		// 因为每个库的xzqh叫法不一样.所以根据实际库里的叫法来对应查询
		if ("420120000000".equals(xzqh)) {
			xzqh = "东湖风景区";
		} else if ("420119000000".equals(xzqh)) {
			xzqh = "东湖高新区";
		} else if ("420118000000".equals(xzqh)) {
			xzqh = "经开区";
		} else if ("420114000000".equals(xzqh)) {
			xzqh = "蔡甸";
		} else if ("420100000000".equals(xzqh)||"420101000000".equals(xzqh)) {
			list = fumeUnitMapper.getTampBlackInfoNew(null);
			if (list.size() < 1) {
				return new ArrayList<>();
			}
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setWarningType("油烟报警");
				list.get(i).setId(i);
			}

			return list;
		} else {
			xzqh = XZQHListener.XZQHMap.get(xzqh);
		}
		list = fumeUnitMapper.getTampBlackInfoNew("%"+xzqh+"%");
			if (list.size() < 1) {
				return new ArrayList<>();
			}
//			for (LampBlack lampBlack : list) {
//				Gps xy84 = PositionUtil.gcj_To_Gps84(Double.parseDouble(lampBlack.getY()),
//						Double.parseDouble(lampBlack.getX()));
//				lampBlack.setX(xy84.getWgLon() + "");
//				lampBlack.setY(xy84.getWgLat() + "");
//			}
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setWarningType("油烟报警");
				list.get(i).setId(i);
			}

			return list;
		} catch (Exception e) {
			log.error("餐厨油烟单位信息查询失败!!");
			return new ArrayList<>();
		}
	}

	@Override
	public List<Map<String, Object>> getViolationNum(String xzqh) {
		try {
			String substring = XZQHListener.XZQHMap.get(xzqh);
			String xzqh_str = substring.substring(0, 2);
			// String table = "SSYYBJXX_HISTORY_"+DateTime.getYearMonth();

			List<Map<String, Object>> violationNum = new ArrayList<Map<String, Object>>();
			if ("全市".equals(xzqh_str)) {
				violationNum = fumeUnitMapper.getViolationNum(null);
			} else {
				violationNum = fumeUnitMapper.getViolationNum("%" + xzqh_str + "%");
			}
			if (violationNum.size() < 1) {
				return new ArrayList<>();
			}
			return violationNum;

		} catch (Exception e) {
			log.error("获得餐饮油烟单位近7天违规数失败");
			return new ArrayList<>();
		}

	}
	
	/**
	 * 获得前7日油烟报警最多的餐饮单位
	 */
	public List<MostFumeUnit> getMostCyyydw(){
		String [] ts = DateTime.getPast7Dates();
//		String []ts = {"2019-04-29","2019-05-06"};
		String startTime = ts[0];
		String endTime = ts [1];
		String tableName = "";
		List<MostFumeUnit> a = null;
		try {
			if(startTime.substring(5, 7).equals(endTime.substring(5, 7))){
				tableName = startTime.substring(0,7).replace("-","_");
				String sql = " select hotelname ,count(hotelname)sum  from SSYYBJXX_HISTORY_"+tableName+" where alarmtime between trunc(sysdate)-7 and trunc(sysdate) group by hotelname order by sum desc";
				
				 a  = fumeUnitMapper.getMostAlarm(sql);
			}else{
				tableName= startTime.substring(0,7).replace("-", "_");
				String tableName2 = endTime.substring(0,7).replace("-","_");
				
				String sql = "select t.hotelname,count(t.hotelname) sum  from (select *  from SSYYBJXX_HISTORY_"+tableName+" union all "
						+ " select *  from SSYYBJXX_HISTORY_"+tableName2+")  t"+
							" where t.alarmtime >= to_date('"+startTime+"','yyyy-MM-dd') and"
							+ " t.alarmtime< to_date('"+endTime+"','yyyy-MM-dd')group by hotelname order by sum desc";
				a  = fumeUnitMapper.getMostAlarm(sql);
			}
			if(a.size()>=10){
				a = a.subList(0, 10);
			}
			return  a ;
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ArrayList<>();
		}
		
		
	}
}
