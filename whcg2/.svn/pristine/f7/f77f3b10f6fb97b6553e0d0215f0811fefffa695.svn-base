package com.ltsk.whcg.bridgeDefect.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface BridgeDefectMapper {
	@Select("select state,count(distinct(t.keyid)) num from MANGER_ZHXTZX.BHM_ALARMINFO t group by t.state")
	public List<Map<String, Object>> getBridgeDefectNumGroupStatus();
	
	@Select("select t1.num+t2.num 总数,t2.num 桥梁处,t1.num 行业监管 from (select count(distinct(t.bridgename)) num from MANGER_ZHXTZX.BHM_BASE_BRIDGECARDINFO t " +
			"where managetype='行业监管' and manageunit is not null and t.frontalviewpic is not null) t1,(select count(distinct(t.bridgename)) num from MANGER_ZHXTZX.BHM_BASE_BRIDGECARDINFO t " +
			"where manageunit is not null and t.managetype='直接监管'  and t.citygirderform is not null)t2")
	public Map<String, Object> getBridgeDefectNumGroupUnit();
	
	@Select("select  nvl(t.buildkind,'其他桥') type,count(distinct(t.bridgename)) num from MANGER_ZHXTZX.BHM_BASE_BRIDGECARDINFO t where bridgename is not null group by t.buildkind order by num desc")
	public List<Map<String, Integer>> getBridgeNumGroupBuildkind();
	
	@Select("select nvl(t.buildsize,'其他桥') type,count(distinct(t.bridgename)) num from MANGER_ZHXTZX.BHM_BASE_BRIDGECARDINFO t group by t.buildsize order by num desc")
	public List<Map<String, Integer>> getBridgeNumGroupBuildsize();
}
