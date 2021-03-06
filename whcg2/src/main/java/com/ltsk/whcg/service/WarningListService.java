package com.ltsk.whcg.service;

import com.ltsk.whcg.entity.GasWarningList;
import com.ltsk.whcg.entity.StationDetail;
import com.ltsk.whcg.entity.WarningList;

import java.util.List;
import java.util.Map;

public interface WarningListService {
    List<WarningList> getAll();


	List<GasWarningList> getWarning(String xzqh);


	Map<String,List<StationDetail>> getEqDevice(String xzqh);


	Object getWarnByXzqh(String xzqh);
}
