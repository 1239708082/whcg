package com.ltsk.whcg.service;

import com.ltsk.whcg.entity.GarbageNow;
import com.ltsk.whcg.entity.Gfczzd;
import com.ltsk.whcg.entity.LastWeekSHLJ;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public interface HouseholdGarbageFactoryService {

    List<Gfczzd> getAll(String xzqhname);

    List<List<LastWeekSHLJ>> getLastWeek(String xzqh);

	List<GarbageNow> getNowGarbage(String xzqh);

	Object getSumGarbage(String xzqh);
	
	HSSFWorkbook getCzjl_tj(String startTime,String endTime,String handleunit,String xzqh);
	
	List<Map<String, Object>> getCzjl_tj_list(String startTime,String endTime,String handleunit,String xzqh,Integer pageNo,Integer totalCount);
	//获得表头名称
	String title(String startTime,String endTime,String handleunit,String xzqh);
	//总条数
	Integer count(String startTime,String endTime,String handleunit,String xzqh);
	
	List<String> area();
	
	List<String> handleunit(String startTime,String endTime,String handleunit,String xzqh);
}
