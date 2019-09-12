package com.ltsk.whcg.base.mapper;

import com.ltsk.whcg.entity.Cyyycginfo;
import com.ltsk.whcg.entity.LampBlack;
import com.ltsk.whcg.entity.MostFumeUnit;
import com.ltsk.whcg.entity.Muck;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 油烟单位
 */
@Repository
public interface FumeUnitMapper {

//    @Select("select * from CYYYCGINFO")
	@Select({"<script>",
        "SELECT * FROM CYYYCGINFO t",
        "WHERE lng like '114%' and lat like '30%' ",
        "<when test='xzqh!=null'>",
        "AND district = #{xzqh}",
        "</when>",
        "</script>"})
    List<Cyyycginfo> getAll(@Param("xzqh")String xzqh);


	@Select({"<script>",
        "SELECT t.alarmvalue alarmvalue,t.hotelname hotelname,t.alarmtime alarmtime,t.alarmtype alarmtype,b.gdx x ,b.gdy y FROM SSYYBJXX t ,CYYYCGINFO b ",
        "WHERE t.hotelname=b.hotelname and  t.alarmtime > trunc(sysdate) and b.gdx like '114%' and b.gdy like '30%' ",
        "<when test='xzqh!=null'>",
        "AND b.district = #{xzqh}",
        "</when>",
        "order by t.alarmtime desc",
        "</script>"})
	List<LampBlack> getTampBlackInfo(@Param("xzqh")String xzqh);
	
	@Select({"<script>",
        "SELECT alarmvalue , hotelname, alarmtime, alarmtype FROM SSYYBJXX  ",
        "WHERE alarmtime > trunc(sysdate)  ",
        "<when test='xzqh!=null'>",
        "AND  hotelname  like  #{xzqh}",
        "</when>",
        "order by alarmtime desc",
        "</script>"})
	List<LampBlack> getTampBlackInfoNew(@Param("xzqh")String xzqh);
	
//	餐饮油烟单位今日报警类型信息
	@Select({"<script>",
        "SELECT alarmtype as type,count(distinct(hotelname)) as num FROM SSYYBJXX ",
        "where alarmtime >trunc(sysdate)",
        "<when test='xzqh!=null'>",
        "and hotelname like #{xzqh}",
        "</when>",
        "group by alarmtype",
        "</script>"})
	public List<Map<String, Object>> getViolationNum(@Param("xzqh")String xzqh);


	@Select("${sql}")
	public List<MostFumeUnit> getMostAlarm(@Param("sql") String sql);
}
