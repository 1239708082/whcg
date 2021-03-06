package com.ltsk.whcg.service;

import com.ltsk.whcg.entity.Cyyycginfo;
import com.ltsk.whcg.entity.LampBlack;
import com.ltsk.whcg.entity.MostFumeUnit;

import java.util.List;
import java.util.Map;

public interface FumeUnitService {
    List<Cyyycginfo> getAll(String xzqh);

	List<LampBlack> getTampblack(String xzqh);
	
	List<Map<String, Object>> getViolationNum(String xzqh);
	List<MostFumeUnit> getMostCyyydw();
}
