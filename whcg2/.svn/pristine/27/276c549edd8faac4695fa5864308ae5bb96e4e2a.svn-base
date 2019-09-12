package com.ltsk.whcg.base.mapper;

import com.ltsk.whcg.entity.Czjl_excel;
import com.ltsk.whcg.entity.GarbageNow;
import com.ltsk.whcg.entity.Gfczzd;
import com.ltsk.whcg.entity.LastWeekSHLJ;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 生活垃圾处理厂
 */
@Repository
public interface HouseholdGarbageFactoryMapper {

//    @Select("select * from GFCZZD t where t.longitudedone != 'null' and xzqhname=#{xzqhname}")
	@Select({"<script>",
        "SELECT * FROM GFCZZD t",
        "WHERE t.longitudedone != 'null'",
        "<when test='xzqhname!=null'>",
        "AND xzqhname = #{xzqhname}",
        "</when>",
        "</script>"})
    List<Gfczzd> getAll(@Param("xzqhname")String xzqhname);
	
	
//查询前7天的每天的生活垃圾处理量
	

	@Select("select handleunit,round(sum(netweight)) netweight,to_char(grossdatetime,'yyyy-mm-dd') day  from CZJL t where grossdatetime  between trunc(sysdate)-7  and trunc(sysdate)  group by handleunit,to_char(grossdatetime,'yyyy-mm-dd') order by handleunit,day ")
	List<LastWeekSHLJ> getLastWeek();
	
	//查询前几天某区的每天的生活垃圾处理量
	@Select("select area handleunit ,round(sum(netweight)) netweight,to_char(grossdatetime,'yyyy-mm-dd') day  from CZJL t where grossdatetime  between trunc(sysdate)-7  and trunc(sysdate) and area = #{xzqh}  group by area,to_char(grossdatetime,'yyyy-mm-dd') order by to_char(grossdatetime,'yyyy-mm-dd')")
	List<LastWeekSHLJ> getLastWeekByXzqh(@Param("xzqh")String xzqh);
	
	
//查询生活垃圾各区实时统计量
 	
	@Select("select c.area xzqh,round(sum(netweight)) weigh from CZJL c left join xzqh x on c.area=x.name  " +
			"where grossdatetime> trunc(sysdate) group by c.area order by min(x.id)")
	List<GarbageNow> getPresentGarbage();


	@Select("select trunc(to_number(to_char(grossdatetime, 'hh24')) / 2) as  time,round(sum(netweight)) as weigh from czjl where grossdatetime > trunc(sysdate) and area =#{xzqh} group by trunc(to_number(to_char(grossdatetime, 'hh24')) / 2) order by  time")
	List<GarbageNow> getPerByXzqh(@Param("xzqh")String xzqh);

	
	
	//@Select("select sum(netweight)weigh from CZJL where grossdatetime> trunc(sysdate)  ")
	@Select("<script> " +  
            "SELECT sum(netweight)weigh " +  
            "from CZJL " + 
            "where grossdatetime> trunc(sysdate) and productinorout = '1' "+
            " <if test='xzqh != null'>and area=#{xzqh}</if> " +  
            " </script> ")  
	Double getSumGarbage(@Param("xzqh")String xzqh);
	
	
	//生活垃圾各厂实时进厂量
	@Select("SELECT round(sum(netweight)) weigh,handleunit xzqh FROM CzJL  where grossdatetime>=trunc(sysdate) group by handleunit order by weigh")
	List<GarbageNow> getByHandle();
	
	//垃圾量统计报表
	@Select("<script> " +  
            "select max(t.id) id,area,t.transportunit,t.carno,count(t.carno) count,sum(t.netweight) sum,max(t2.lastsum) lastsum ,max(t2.lastsum)-sum(t.netweight) result,max(handleunit) handleunit " +  
            "from CZJL t " + 
            "left join (select carno ,sum(t.netweight) lastsum from CZJL t where 1=1 "+ 
            "<if test='startTime != null and endTime!=null'>and t.grossdatetime between to_date(#{startTime_last},'yyyy/mm/dd') and to_date(#{endTime_last},'yyyy/mm/dd') </if>"+
            "group by carno) t2 on t.carno=t2.carno "+
            "where 1=1"+
            " <if test='startTime != null and endTime!=null'>and grossdatetime between to_date(#{startTime},'yyyy/mm/dd') and to_date(#{endTime},'yyyy/mm/dd') </if> " +  
            " <if test='handleunit != null'>and handleunit=#{handleunit} </if> " + 
            " <if test='xzqh != null'>and area=#{xzqh}</if> " + 
            "group by area,transportunit,t.carno order by area,transportunit "+
            " </script> ")  
	List<Czjl_excel> getCzjl_tj(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("handleunit")String handleunit,@Param("xzqh")String xzqh,@Param("startTime_last")String startTime_last,@Param("endTime_last")String endTime_last);
	
	@Select("<script> " +  
            "select * from (select rownum ro ,t.* from (select max(t.id) id,area,t.transportunit,t.carno,count(t.carno) count,sum(t.netweight) sum,max(t2.lastsum) lastsum ,max(t2.lastsum)-sum(t.netweight) result " +  
            "from CZJL t " + 
            "left join (select carno ,sum(t.netweight) lastsum from CZJL t where 1=1 "+ 
            "<if test='startTime != null and endTime!=null'>and t.grossdatetime between to_date(#{startTime_last},'yyyy/mm/dd') and to_date(#{endTime_last},'yyyy/mm/dd') </if>"+
            "group by carno) t2 on t.carno=t2.carno "+
            "where 1=1"+
            " <if test='startTime != null and endTime!=null'>and grossdatetime between to_date(#{startTime},'yyyy/mm/dd') and to_date(#{endTime},'yyyy/mm/dd') </if> " +  
            " <if test='handleunit != null'>and handleunit=#{handleunit} </if> " + 
            " <if test='xzqh != null'>and area=#{xzqh}</if> " + 
            "group by area,transportunit,t.carno order by area,transportunit) t where #{page2}>rownum) t1 where ro>#{page1}"+
            " </script> ")  
	public List<Czjl_excel> getCzjlGroupByPage(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("handleunit")String handleunit,@Param("xzqh")String xzqh,@Param("startTime_last")String startTime_last,@Param("endTime_last")String endTime_last,@Param("page1") Integer page1,@Param("page2")Integer page2);
	@Select("<script>"
			+ "select count(count(*)) from CZJL t "
			+ "where t.grossdatetime between to_date(#{startTime},'yyyy/mm/dd') "
			+ "and to_date(#{endTime},'yyyy/mm/dd') "
			+ "<if test='xzqh != null'>and area=#{xzqh} </if>"
			+ "<if test='handleunit != null'>and handleunit=#{handleunit} </if> "
			+ "group by area,transportunit,t.carno"
			+ "</script>")
	public Integer count(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("handleunit")String handleunit,@Param("xzqh")String xzqh);
	@Select("select handleunit from CZJL group by handleunit")
	public List<String> handleunit();
}
