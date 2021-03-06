package com.ltsk.whcg.service;

import com.ltsk.whcg.entity.Ccljc;
import com.ltsk.whcg.entity.Czjl;
import com.ltsk.whcg.entity.GarbageNow;

import java.util.List;

public interface KitchenWasteFactoryService {
    List<Ccljc> getAll();

	List<Czjl> getAllToday(Integer page, Integer rows, String startTime, String endTime,String area, String unit);

	Integer getCountToday(String startTime,String endTime, String area, String unit);

	Integer getIn(String startTime,String endTime, String area, String unit);

	Integer getOut(String startTime,String endTime, String area, String unit);

	Double getInNum(String startTime,String endTime, String area, String unit);
	
	Double getOutNum(String startTime,String endTime, String area, String unit);

	List<String> getUnit();

	List<String> getArea();

	List<Czjl> getAllList(String startTime,String endTime, String area, String unit);

	List<GarbageNow> getAllByArea(String startTime, String endTime);

}
