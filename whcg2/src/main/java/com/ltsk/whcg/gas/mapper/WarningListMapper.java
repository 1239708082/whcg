package com.ltsk.whcg.gas.mapper;

import com.ltsk.whcg.entity.WarningArea;
import com.ltsk.whcg.entity.WarningList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarningListMapper {

    @Select("select * from [rq].[dbo].[WarningList] where DateDiff(dd,OccurDate,getdate())= 0 and Status = 1 ORDER BY OccurDate desc")
    public List<WarningList> getAll();

//    @Select("SELECT count(*) num FROM [rq].[dbo].[WarningList] where DateDiff(dd,OccurDate,getdate())= 0 and Status = 1 ")
    @Select("<script> " +  
            "SELECT count(*)  num " +  
            "from [rq].[dbo].[WarningList]    " + 
            "where DateDiff(dd,OccurDate,getdate())= 0 and Status = 1 "+
            " <if test='xzqhname != null'>and Areaname =#{xzqhname}</if> " +  
            " </script> ") 
    public Integer getGasWarning(@Param("xzqhname") String xzqh);

    //得到今日报警次数
    @Select("<script> " +  
            "SELECT count(*)   " +  
            "from [rq].[dbo].[WarningList]    " + 
            "where DateDiff(dd,OccurDate,getdate())= 0  "+
            " <if test='xzqhname != null'>and Areaname =#{xzqhname}</if> " +  
            " </script> ") 
	public Integer getWarningToday(@Param("xzqhname") String xzqh);
    
    //得到昨天报警次数
    @Select("<script> " +  
            "SELECT count(*)  todayDate " +  
            "from [rq].[dbo].[WarningList]    " + 
            "where DateDiff(dd,OccurDate,getdate())=1 "+
            " <if test='xzqhname != null'>and Areaname =#{xzqhname}</if> " +  
            " </script> ") 
	public Integer getWarningYesterday(@Param("xzqhname") String xzqh);
    
    
    //查询设备正常数
//    @Select("select count(wstatus) from [rq].[dbo].[t_s_station] where wstatus=0")
    @Select("<script> " +  
            "SELECT count(wstatus) " +  
            "from [rq].[dbo].[t_s_station]    " + 
            "where wstatus=0 "+
            " <if test='xzqhname != null'>and area =#{xzqhname}</if> " +  
            " </script> ") 
    public Integer getNormal(@Param("xzqhname") String xzqh);
    
    //今日离线站点
//    @Select("select count(wstatus) from [rq].[dbo].[t_s_station] where wstatus=-1")
    @Select("<script> " +  
            "SELECT count(wstatus) " +  
            "from [rq].[dbo].[t_s_station]    " + 
            "where wstatus=-1 "+
            " <if test='xzqhname != null'>and area =#{xzqhname}</if> " +  
            " </script> ") 
    public Integer getOffline(@Param("xzqhname") String xzqh);

    //今日泄漏总数
//    @Select("select count(*) from [rq].[dbo].[WarningList]  where  wxStatus=1 and  DateDiff(dd,OccurDate,getdate())= 0")
    @Select("<script> " +  
            "SELECT count(*)   " +  
            "from [rq].[dbo].[WarningList]    " + 
            "where wxStatus=1 and  DateDiff(dd,OccurDate,getdate())= 0 "+
            " <if test='xzqhname != null'>and Areaname =#{xzqhname}</if> " +  
            " </script> ") 
    public Integer getOut(@Param("xzqhname") String xzqh);
    
    //燃气总设备数
//    @Select("select count(wstatus) from [rq].[dbo].[t_s_station]   ")
    @Select("<script> " +  
            "SELECT count(wstatus) " +  
            "from [rq].[dbo].[t_s_station]    " + 
            "where 1=1 "+
            " <if test='xzqhname != null'>and area =#{xzqhname}</if> " +  
            " </script> ") 
    public Integer getAllEq(@Param("xzqhname") String xzqh);
    
    //本周离线次数
//    @Select("select count(*)  from [rq].[dbo].[WarningList]  where OccurDate>=DATEADD(wk, DATEDIFF(wk,0,DATEADD(dd, -1, getdate()) ), 0) and OccurDate<DATEADD(wk, DATEDIFF(wk,0,DATEADD(dd, -1, getdate()) ), 7) and wxStatus=0")
    @Select("<script> " +  
            "SELECT count(*)   " +  
            "from [rq].[dbo].[WarningList]    " + 
            "where OccurDate &gt;=	DATEADD(wk, DATEDIFF(wk,0,DATEADD(dd, -1, getdate()) ), 0) and OccurDate &lt; DATEADD(wk, DATEDIFF(wk,0,DATEADD(dd, -1, getdate()) ), 7) and wxStatus=0 "+
            " <if test='xzqhname != null'>and Areaname =#{xzqhname}</if> " +  
            " </script> ") 
    public Integer getOfflineByWeek(@Param("xzqhname") String xzqh);
    
    //本周泄漏次数
//    @Select("select count(*) from [rq].[dbo].[WarningList]  where OccurDate>=DATEADD(wk, DATEDIFF(wk,0,DATEADD(dd, -1, getdate()) ), 0) and OccurDate<DATEADD(wk, DATEDIFF(wk,0,DATEADD(dd, -1, getdate()) ), 7) and wxStatus=1")
    @Select("<script> " +  
            "SELECT count(*)   " +  
            "from [rq].[dbo].[WarningList]    " + 
            "where  OccurDate &gt;= DATEADD(wk, DATEDIFF(wk,0,DATEADD(dd, -1, getdate()) ), 0) and OccurDate &lt; DATEADD(wk, DATEDIFF(wk,0,DATEADD(dd, -1, getdate()) ), 7) and wxStatus=1 "+
            " <if test='xzqhname != null'>and Areaname =#{xzqhname}</if> " +  
            " </script> ") 
    public Integer getOutByWeek(@Param("xzqhname") String xzqh);

    //区级泄露详情列表
    
    @Select("<script> " +  
          "SELECT convert(char(8),OccurDate,112)  as time,count(*)  as num " +  
          "from [rq].[dbo].[WarningList]    " + 
          "where DateDiff(dd,OccurDate,getdate()) &lt;=7 and DateDiff(dd,OccurDate,getdate()) &gt; 0 "+
          " <if test='xzqhname != null'>and Areaname =#{xzqhname}</if> " +  
          "group by convert(char(8),OccurDate,112) order by time "+
          " </script> ") 
	public List<WarningArea> getAllByXzqh(@Param("xzqhname") String xzqh);
}
